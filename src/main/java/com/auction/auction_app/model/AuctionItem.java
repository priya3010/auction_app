package com.auction.auction_app.model;

import java.sql.Date;

import jakarta.persistence.Entity;

@Entity
public class AuctionItem {
	
	private int aId;
	private String itemName;
	private int reservedPrice;
	private Date startTime;
	private Date endTime;
	private String status;
	private int auctioneerId;
	private int highestBid;
	
	
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getReservedPrice() {
		return reservedPrice;
	}
	public void setReservedPrice(int reservedPrice) {
		this.reservedPrice = reservedPrice;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public int getAuctioneerId() {
		return auctioneerId;
	}
	public void setAuctioneerId(int aid) {
		this.auctioneerId = aid;
	}
	
	
	public int getHighestBid() {
		return highestBid;
	}
	public void setHighestBid(int highestBid) {
		this.highestBid = highestBid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public AuctionItem(int itemId, String itemName, int reservedPrice, Date startTime, Date endTime, String status,
			int auctioneerId, int highestBid) {
		super();
		this.aId = itemId;
		this.itemName = itemName;
		this.reservedPrice = reservedPrice;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
		this.auctioneerId = auctioneerId;
		this.highestBid = highestBid;
	}
	public AuctionItem() {
		// TODO Auto-generated constructor stub
	}
	
	
}
