package com.Lab.action;

import java.sql.SQLException;
import java.util.List;

import com.Lab.dao.Infodao;
import com.Lab.model.Info;

public class InfoAction {
		public static void main(String[] args) throws SQLException {
			Infodao g=new Infodao();
			List<Info> v=g.query();
			for (Info info : v) {
				System.out.println(info.getId()+","+info.getName()+","+info.getSex()+","+info.getTel());
			}			
		}
}
