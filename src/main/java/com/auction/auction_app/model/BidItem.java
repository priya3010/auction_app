package com.auction.auction_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BidItem {
	@Id
	private int bId;
	private int aId;
	private int bidderId;
	private int bidPrice;
	
	
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public int getBidderId() {
		return bidderId;
	}
	public void setBidderId(int bidderId) {
		this.bidderId = bidderId;
	}
	public int getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(int bidPrice) {
		this.bidPrice = bidPrice;
	}
	@Override
	public String toString() {
		return "BidItem [BId=" + bId + ", aId=" + aId + ", bidderId=" + bidderId + ", bidPrice=" + bidPrice + "]";
	}
	
	
}
