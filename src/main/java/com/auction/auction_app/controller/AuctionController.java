package com.auction.auction_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auction.auction_app.dao.AuctionItemDao;
import com.auction.auction_app.dao.BidItemDao;
import com.auction.auction_app.dao.UserRepo;
import com.auction.auction_app.model.AuctionItem;
import com.auction.auction_app.model.BidItem;
import com.auction.auction_app.model.User;

@RestController
public class AuctionController {
	
	@Autowired
	private AuctionItemDao auctionItemDao;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private BidItemDao bidItemDao;
	
	
	@RequestMapping(value="/createAuctionEntry", method=RequestMethod.POST)
	public ResponseEntity<Object> createAuctionEntry(@RequestBody AuctionItem auctionItem){
		int row=0;
		if(auctionItem !=null) {
			row=auctionItemDao.insertAuctionItem(auctionItem);
		}
		
		
		return new ResponseEntity<Object>(row+ " row(s) updated", HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public ResponseEntity<Object> addUser(@RequestBody User user){
				
		int row=0;
		if(user !=null) {
			row=userRepo.addUser(user);
		}
		
		
		return new ResponseEntity<Object>(row+ " row(s) updated", HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/getAuctionItems", method=RequestMethod.GET)
	public ResponseEntity<Object> getAuctionItems(){
				
		List<AuctionItem> auctionItems=auctionItemDao.getAuctionItems();
		return new ResponseEntity<Object>(auctionItems, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/getOpenAuctionItems", method=RequestMethod.GET)
	public ResponseEntity<Object> getOpenAuctionItems(){
				
		List<AuctionItem> auctionItems=auctionItemDao.getOpenAuctionItems();
		return new ResponseEntity<Object>(auctionItems, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/bidForAuction", method=RequestMethod.POST)
	public ResponseEntity<Object> bidForAuction(@RequestBody BidItem bidItem){
		int row=0;
		if(bidItem.getaId() !=0) {
			AuctionItem ai=auctionItemDao.getAuctionItem(bidItem.getaId());
			if(ai.getStatus().equals("closed")) {
				return new ResponseEntity<Object>("Auction is closed", HttpStatus.OK);
			}
			
			if(ai.getStatus().equalsIgnoreCase("not started")) {
				return new ResponseEntity<Object>("Auction has not started yet", HttpStatus.OK);
			}
			
			if(ai.getStatus().equalsIgnoreCase("Open")) {
				if(ai.getReservedPrice() < bidItem.getBidPrice() && ai.getHighestBid() < bidItem.getBidPrice()) {
					row=auctionItemDao.insertBidPrice(bidItem.getaId(),bidItem.getBidPrice());
					int rowBT=bidItemDao.insertBidItem(bidItem);
				}
			}
		}
				
		return new ResponseEntity<Object>(row+ "inserted for bid", HttpStatus.OK);
		
	}
}