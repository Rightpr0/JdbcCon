package com.Lab.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Lab.db.DbUtil;
import com.Lab.model.Info;


public class Infodao {
	
	public void addInfo(){
		
	}
	public void uopdateInfo(){
		
	}
	public void delInfo(){
		
	}
	public List<Info> query() throws SQLException{
		Connection conn=DbUtil.getconConnection();
		Statement sta=conn.createStatement();
		ResultSet rs=sta.executeQuery("select id,name,sex,tel from student");
		
		List<Info> info=new ArrayList<Info>();
		Info v=null;
		
		while(rs.next()){
			v=new Info();
			v.setId(rs.getInt("id"));
			v.setName(rs.getString("name"));
			v.setSex(rs.getString("sex"));
			v.setTel(rs.getString("tel"));
			info.add(v);
		}	
		return info;	
	}
	public Info get(){
		return null;		
	}
}
