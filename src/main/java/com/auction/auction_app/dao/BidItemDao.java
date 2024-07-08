package com.auction.auction_app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.auction.auction_app.model.BidItem;
import com.auction.auction_app.utils.DBConnection;

@Component
public class BidItemDao {

	public int insertBidItem(BidItem bidItem) {
		DBConnection dbconn=new DBConnection();
		Connection conn=dbconn.getDBConnection();
		
		int row=0;
		PreparedStatement ps=null;
		
		try {
			ps=conn.prepareStatement("insert into public.\"BiddingTable\" values (?,?,?,?)");
		
		ps.setInt(1, bidItem.getbId());
		ps.setInt(2, bidItem.getaId());
		ps.setInt(3, bidItem.getBidderId());
		ps.setInt(4, bidItem.getBidPrice());

		
		row=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return row;
	}

}
