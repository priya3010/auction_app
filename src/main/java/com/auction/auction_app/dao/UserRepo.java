package com.auction.auction_app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.auction.auction_app.model.AuctionItem;
import com.auction.auction_app.model.User;
import com.auction.auction_app.utils.DBConnection;

@Component
public class UserRepo {
	private BCryptPasswordEncoder encoder= new BCryptPasswordEncoder(12);
	public User findByUsername(String username) {
		DBConnection dbconn=new DBConnection();
		Connection conn=dbconn.getDBConnection();
		User u=null;
		
		PreparedStatement ps=null;
		
		try {
			ps=conn.prepareStatement("select * from public.\"User\" where \"uname\"=?");
			ps.setString(1, username);
		
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				u=new User();
				u.setUid(rs.getInt("uid"));;
				u.setUname(rs.getString("uname"));
				u.setRole(rs.getString("role"));
				u.setPassword(rs.getString("password"));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return u;
	}
	
	public int addUser(User user) {
		DBConnection dbconn=new DBConnection();
		Connection conn=dbconn.getDBConnection();
		
		int row=0;
		PreparedStatement ps=null;
		
		try {
			ps=conn.prepareStatement("insert into public.\"User\" values (?,?,?,?)");
		
		ps.setInt(1, user.getUid());
		ps.setString(2, user.getUname());
		ps.setString(3, user.getRole());
		ps.setString(4, encoder.encode(user.getPassword()));
		
		row=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return row;
	}

	public User save(User user) {
		DBConnection dbconn=new DBConnection();
		Connection conn=dbconn.getDBConnection();
		
		int row=0;
		PreparedStatement ps=null;
		
		try {
			ps=conn.prepareStatement("update public.\"User\" set \"password\" = ?");
			ps.setString(1, user.getPassword());
		row=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
}
