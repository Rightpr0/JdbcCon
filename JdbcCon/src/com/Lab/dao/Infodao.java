package com.Lab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.Lab.db.DbUtil;
import com.Lab.model.Info;
public class Infodao {
	
	public void addInfo(Info i) throws Exception{
		Connection conn=DbUtil.getconConnection();
		String sql =""+
					"insert into student"+
				    "(id,name,sex,tel)"+
					"values(?,?,?,?)";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, i.getId());
		ptmt.setString(2, i.getName());
		ptmt.setString(3, i.getSex());
		ptmt.setString(4, i.getTel());
		ptmt.execute();		
	}
	public void updateInfo(Info i) throws SQLException{
		Connection conn=DbUtil.getconConnection();
		String sql =""+
					"update student "+
				    "set name=?,sex=?,tel=? "+
					"where id=? ";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, i.getName());
		ptmt.setString(2, i.getSex());
		ptmt.setString(3, i.getTel());
		ptmt.setInt(4, i.getId());
		ptmt.execute();		
		
	}
	public void delInfo(Integer id) throws SQLException{
		Connection conn=DbUtil.getconConnection();
		String sql =""+
					"delete from student "+
					"where id=? ";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, id);
		ptmt.execute();		
		
	}
	public List<Info> query() throws SQLException{
		Connection conn=DbUtil.getconConnection();
		Statement sta=conn.createStatement();
		ResultSet rs=sta.executeQuery("select * from student");
		
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
	public List<Info>query(String name,String tel) throws SQLException{
		List<Info> result =new ArrayList<Info>();
		Connection conn=DbUtil.getconConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select * from student  ");
		
		sb.append(" where name like ? and tel like ? ");
		
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		ptmt.setString(1, "%"+name+"%");
		ptmt.setString(2, "%"+tel+"%");
		System.out.println(sb.toString());
		ResultSet rs=ptmt.executeQuery();
		
        Info v=null;
		while(rs.next()){
			v=new Info();
			v.setId(rs.getInt("id"));
			v.setName(rs.getString("name"));
			v.setSex(rs.getString("sex"));
			v.setTel(rs.getString("tel"));
			result.add(v);
		}	
		return result;
	}
	public List<Info>query(List<Map<String, Object>> params) throws SQLException{
		List<Info> result =new ArrayList<Info>();
		Connection conn=DbUtil.getconConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select * from student whre 1=1  ");
		if(params!=null&&params.size()>0){
			for (int i = 0; i < params.size(); i++) {
				Map<String, Object> map=params.get(i);
				sb.append(" and  "+map.get("name")+" "+map.get("rela")+" "+map.get("value")+" ");
			}
		}
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		System.out.println(sb.toString());
		ResultSet rs=ptmt.executeQuery();
		
        Info v=null;
		while(rs.next()){
			v=new Info();
			v.setId(rs.getInt("id"));
			v.setName(rs.getString("name"));
			v.setSex(rs.getString("sex"));
			v.setTel(rs.getString("tel"));
			result.add(v);
		}	
		return result;
	}
	public Info get(Integer id) throws SQLException{
		Connection conn=DbUtil.getconConnection();
		String sql =""+
					"select * from student "+
					"where id=? ";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, id);
		ResultSet rs=ptmt.executeQuery();
		Info i=null;
		while(rs.next()){
			i=new Info();
			i.setId(rs.getInt("id"));
			i.setName(rs.getString("name"));
			i.setSex(rs.getString("sex"));
			i.setTel(rs.getString("tel"));
		}
		return i;		
	}
}
