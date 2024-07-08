package com.auction.auction_app.scheduler;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.auction.auction_app.dao.AuctionItemDao;
import com.auction.auction_app.model.AuctionItem;

@Component
@EnableScheduling
public class AuctionScheduler {
	
	@Autowired
	private AuctionItemDao auctionItemDao;

	//@Scheduled(fixedDelay=24L*60L*60L*1000L)
	public void scheduleAuction() {
		//get the auctions scheduled for today
		long millis=System.currentTimeMillis(); 
		Date currDate=new Date(millis);
		List<AuctionItem> listStartingAuctions=auctionItemDao.getTodaysAuctions(currDate);
		List<AuctionItem> listEndingAuctions=auctionItemDao.getTodaysEndingAuctions(currDate);
		if(listStartingAuctions.size()>0) {
			int row=auctionItemDao.setStatusOpen(listStartingAuctions);
			System.out.println(row +" rows status have been updated to open");
		}
		
		if(listEndingAuctions.size()>0) {
			int row=auctionItemDao.setStatusClosed(listEndingAuctions);
			System.out.println(row +" rows status have been updated to closed");
		}
	}
}
