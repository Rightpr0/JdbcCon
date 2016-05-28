package com.Lab.Test;

import com.Lab.dao.Infodao;
import com.Lab.model.Info;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
			Infodao dao =new Infodao();
			
//			Info i =new Info();
//			i.setId(123456);
//			i.setName("Ð¡ÏÄ");
//			i.setSex("Å®");
//			i.setTel("18133331111");
//			i.setId(123456);
//			dao.addInfo(i);
//			dao.updateInfo(i);
//			dao.delInfo(123456);
			Info i=dao.get(123456);
			System.out.println(i.toString());
	}

}
