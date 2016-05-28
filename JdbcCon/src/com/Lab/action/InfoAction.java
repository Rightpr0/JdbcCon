package com.Lab.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.Lab.dao.Infodao;
import com.Lab.model.Info;

public class InfoAction {
	
	public void add(Info info) throws Exception{
		Infodao dao=new Infodao();
		dao.addInfo(info);
	}
	
	public Info get(Integer id) throws SQLException{
		Infodao dao=new Infodao();
		return dao.get(id);
	}
	
	public void edit(Info info) throws Exception{
		Infodao dao=new Infodao();
		dao.updateInfo(info);
	}
	public void del(Integer id) throws SQLException{
		Infodao dao=new Infodao();
		dao.delInfo(id);
	}
	
	public List<Info>  query() throws Exception{
		Infodao dao=new Infodao();
		return dao.query();
	}
	public List<Info> query(List<Map<String, Object>> params) throws Exception{
		Infodao dao=new Infodao();
		return dao.query(params);
	}
}
