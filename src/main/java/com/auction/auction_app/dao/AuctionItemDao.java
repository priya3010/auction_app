package com.auction.auction_app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.auction.auction_app.model.AuctionItem;
import com.auction.auction_app.utils.DBConnection;

@Component
public class AuctionItemDao {
	public int insertAuctionItem(AuctionItem auctionItem) {
		DBConnection dbconn=new DBConnection();
		Connection conn=dbconn.getDBConnection();
		
		int row=0;
		PreparedStatement ps=null;
		
		try {
			ps=conn.prepareStatement("insert into public.\"AuctionTable\" values (?,?,?,?,?,?,?)");
		
		ps.setInt(1, auctionItem.getaId());
		ps.setString(2, auctionItem.getItemName());
		ps.setInt(3, auctionItem.getReservedPrice());
		ps.setDate(4, auctionItem.getStartTime());
		ps.setDate(5, auctionItem.getEndTime());
		ps.setString(6, auctionItem.getStatus());
		ps.setInt(7, auctionItem.getAuctioneerId());
		
		row=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return row;
		
	}

	public List<AuctionItem> getAuctionItems() {
		DBConnection dbconn=new DBConnection();
		Connection conn=dbconn.getDBConnection();
		
		List<AuctionItem> list=new ArrayList<AuctionItem>();
		PreparedStatement ps=null;
		
		try {
			ps=conn.prepareStatement("select * from public.\"AuctionTable\"");
		
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				AuctionItem ai=new AuctionItem();
				ai.setaId(rs.getInt("aId"));
				ai.setItemName(rs.getString("itemName"));
				ai.setReservedPrice(rs.getInt("reservedPrice"));
				ai.setStartTime(rs.getDate("startTime"));
				ai.setEndTime(rs.getDate("endTime"));
				ai.setStatus(rs.getString("status"));
				ai.setAuctioneerId(rs.getInt("auctioneerId"));
				list.add(ai);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}

	public AuctionItem getAuctionItem(int aId) {
		DBConnection dbconn=new DBConnection();
		Connection conn=dbconn.getDBConnection();
		
		AuctionItem ai=new AuctionItem();
		PreparedStatement ps=null;
		
		try {
			ps=conn.prepareStatement("select * from public.\"AuctionTable\" where \"AId\"=?");
			ps.setInt(1, aId);
		
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				ai.setaId(rs.getInt("aId"));
				ai.setItemName(rs.getString("itemName"));
				ai.setReservedPrice(rs.getInt("reservedPrice"));
				ai.setStartTime(rs.getDate("startTime"));
				ai.setEndTime(rs.getDate("endTime"));
				ai.setStatus(rs.getString("status"));
				ai.setAuctioneerId(rs.getInt("auctioneerId"));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ai;
		
	}

	public int insertBidPrice(int aId, int bidPrice) {
		DBConnection dbconn=new DBConnection();
		Connection conn=dbconn.getDBConnection();
		
		int row=0;
		PreparedStatement ps=null;
		
		try {
			ps=conn.prepareStatement("update public.\"AuctionTable\" set \"highestBid\"=? where \"AId\"=?");
			ps.setInt(1,bidPrice);
			ps.setInt(2, aId);
		
		row=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return row;
	}

	public List<AuctionItem> getOpenAuctionItems() {
		DBConnection dbconn=new DBConnection();
		Connection conn=dbconn.getDBConnection();
		
		List<AuctionItem> list=new ArrayList<AuctionItem>();
		PreparedStatement ps=null;
		
		try {
			ps=conn.prepareStatement("select * from public.\"AuctionTable\" where \"Status\"=?");
			ps.setString(1, "Open");
		
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				AuctionItem ai=new AuctionItem();
				ai.setaId(rs.getInt("aId"));
				ai.setItemName(rs.getString("itemName"));
				ai.setReservedPrice(rs.getInt("reservedPrice"));
				ai.setStartTime(rs.getDate("startTime"));
				ai.setEndTime(rs.getDate("endTime"));
				ai.setStatus(rs.getString("status"));
				ai.setAuctioneerId(rs.getInt("auctioneerId"));
				list.add(ai);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public List<AuctionItem> getTodaysAuctions(Date currDate) {
		DBConnection dbconn=new DBConnection();
		Connection conn=dbconn.getDBConnection();
		
		List<AuctionItem> list=new ArrayList<AuctionItem>();
		PreparedStatement ps=null;
		
		try {
			ps=conn.prepareStatement("select * from public.\"AuctionTable\" where \"StartTime\"=?");
			ps.setDate(1, currDate);
		
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				AuctionItem ai=new AuctionItem();
				ai.setaId(rs.getInt("aId"));
				ai.setItemName(rs.getString("itemName"));
				ai.setReservedPrice(rs.getInt("reservedPrice"));
				ai.setStartTime(rs.getDate("startTime"));
				ai.setEndTime(rs.getDate("endTime"));
				ai.setStatus(rs.getString("status"));
				ai.setAuctioneerId(rs.getInt("auctioneerId"));
				list.add(ai);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public List<AuctionItem> getTodaysEndingAuctions(Date currDate) {
		DBConnection dbconn=new DBConnection();
		Connection conn=dbconn.getDBConnection();
		
		List<AuctionItem> list=new ArrayList<AuctionItem>();
		PreparedStatement ps=null;
		
		try {
			ps=conn.prepareStatement("select * from public.\"AuctionTable\" where \"EndTime\"=?");
			ps.setDate(1, currDate);
		
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				AuctionItem ai=new AuctionItem();
				ai.setaId(rs.getInt("aId"));
				ai.setItemName(rs.getString("itemName"));
				ai.setReservedPrice(rs.getInt("reservedPrice"));
				ai.setStartTime(rs.getDate("startTime"));
				ai.setEndTime(rs.getDate("endTime"));
				ai.setStatus(rs.getString("status"));
				ai.setAuctioneerId(rs.getInt("auctioneerId"));
				list.add(ai);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public int setStatusClosed(List<AuctionItem> listEndingAuctions) {
		DBConnection dbconn=new DBConnection();
		Connection conn=dbconn.getDBConnection();
		
		int row=0;
		for(AuctionItem ai:listEndingAuctions) {
			PreparedStatement ps=null;
			
			try {
				ps=conn.prepareStatement("update public.\"AuctionTable\" set \"Status\"=? where \"AId\"=?");
				ps.setString(1,"Closed");
				ps.setInt(2, ai.getaId());
			
			row+=ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return row;
	}

	public int setStatusOpen(List<AuctionItem> listStartingAuctions) {
		DBConnection dbconn=new DBConnection();
		Connection conn=dbconn.getDBConnection();
		
		int row=0;
		for(AuctionItem ai:listStartingAuctions) {
			PreparedStatement ps=null;
			
			try {
				ps=conn.prepareStatement("update public.\"AuctionTable\" set \"Status\"=? where \"AId\"=?");
				ps.setString(1,"Open");
				ps.setInt(2, ai.getaId());
			
			row+=ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return row;
	}
	
	
}
