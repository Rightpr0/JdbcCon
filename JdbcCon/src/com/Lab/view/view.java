package com.Lab.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.Lab.action.InfoAction;
import com.Lab.model.Info;

public class view {
	private static final String CONTEXT="欢迎来到简易通讯录：\n" +
			"下面是简易通讯录的功能列表：\n" +
			"[MAIN/M]:主菜单\n" +
			"[QUERY/Q]:查看通讯录的全部信息\n" +
			"[GET/G]:查看某位联系人的详细信息\n" +
			"[ADD/A]:添加联系人信息\n" +
			"[UPDATE/U]:更新联系人信息\n" +
			"[DELETE/D]:删除联系人信息\n" +
			"[SEARCH/S]:查询联系人信息(根据姓名、手机号来查询)\n" +
			"[EXIT/E]:退出 简易通讯录\n";

	
	private static final String OPERATION_MAIN="MAIN";
	private static final String OPERATION_QUERY="QUERY";
	private static final String OPERATION_GET="GET";
	private static final String OPERATION_ADD="ADD";
	private static final String OPERATION_UPDATE="UPDATE";
	private static final String OPERATION_DELETE="DELETE";
	private static final String OPERATION_SEARCH="SEARCH";
	private static final String OPERATION_EXIT="EXIT";
	
	public static void main(String[] args) throws Exception {
		
		System.out.println(CONTEXT);
		
		Scanner s=new Scanner(System.in);
		InfoAction action=new InfoAction();
		
		String pervious=null;
		Integer step=1;
		Info go=null;
		
		while(s.hasNext()){
			String in=s.next();
			if(OPERATION_EXIT.equals(in.toUpperCase())
					||OPERATION_EXIT.substring(0, 1).equals(in.toUpperCase())){
				System.out.println("您已成功退出简易通讯录");
				break;
			}else if(OPERATION_MAIN.equals(in.toUpperCase())
					||OPERATION_MAIN.substring(0, 1).equals(in.toUpperCase())){
				step=1;
				pervious=null;
				go=null;
				System.out.println(CONTEXT);
			}else if(OPERATION_QUERY.equals(in.toUpperCase())
					||OPERATION_QUERY.substring(0, 1).equals(in.toUpperCase())){
				List<Info> list=action.query();
				for (Info goddess : list) {
					System.out.println(goddess.toString());
				}
			}else if(OPERATION_GET.equals(in.toUpperCase())
					||OPERATION_GET.substring(0, 1).equals(in.toUpperCase())
					||OPERATION_GET.equals(pervious)){
				pervious=OPERATION_GET;
				if(1==step){
					System.out.println("请输入查询的联系人ID：");
				}else if(step>1){
					Integer id=null;
					Info g;
					try {
						id = Integer.valueOf(in);
						try {
							g = action.get(id);
							if(g==null){
								System.out.println("查询联系人信息失败");
							}else{
								System.out.println(g.toString());
							}
						} catch (Exception e) {
							System.out.println("查询联系人信息失败");
						}
					} catch (Exception e) {
						System.out.println("请输入正确的联系人ID：");
					}
					
				}
				step++;
			}else if(OPERATION_ADD.equals(in.toUpperCase())
					||OPERATION_ADD.substring(0, 1).equals(in.toUpperCase())
					||OPERATION_ADD.equals(pervious)){
				pervious=OPERATION_ADD;
				if(1==step){
					System.out.println("请输入联系人的信息[姓名]：");
				}else if(2==step){
					go=new Info();
					go.setName(in);
					System.out.println("请输入联系人的信息[性别]：");
				}else if(3==step){
					go.setSex(in);
					System.out.println("请输入联系人的信息[电话]：");
				}else if(4==step){
					go.setTel(in);
				try {
					action.add(go);
				} catch (Exception e) {
					System.out.println("新增联系人信息失败");
				}
					System.out.println("新增联系人信息成功");
					step=1;
					pervious=null;
				}
				if(OPERATION_ADD.equals(pervious)){
					step++;
				}
			}else if(OPERATION_UPDATE.equals(in.toUpperCase())
					||OPERATION_UPDATE.substring(0, 1).equals(in.toUpperCase())
					||OPERATION_UPDATE.equals(pervious)){
				pervious=OPERATION_UPDATE;
				if(1==step){
					System.out.println("请输入要修改的联系人ID：");
				}else if(2==step){
					Integer id=null;
					try {
						id = Integer.valueOf(in);
						try {
							go = action.get(id);
							if(go==null){
								System.out.println("查询女神联系人失败");
								step=1;
							}
						} catch (Exception e) {
							System.out.println("查询联系人信息失败");
							step=1;
						}
					} catch (Exception e) {
						System.out.println("请输入正确的联系人ID：");
						step=1;
					}
					System.out.println("请输入新的联系人信息[姓名]，如果不修改该值，请输入-1：");
				}else if(3==step){
					if(-1!=Integer.valueOf(in)){
						go.setName(in);
					}
					System.out.println("请输入新的联系人信息[性别]，如果不修改该值，请输入-1：");
				}else if(4==step){
					if(-1!=Integer.valueOf(in)){
						go.setSex(in);
					}
					System.out.println("请输入新的联系人信息[手机号]，如果不修改该值，请输入-1：");
				}else if(5==step){
					if(-1!=Integer.valueOf(in)){
						go.setTel(in);
					}
					try {
						action.edit(go);
					} catch (Exception e) {
						System.out.println("更新联系人信息失败");
					}
					System.out.println("更新联系人信息成功");
					step=1;
					pervious=null;
				}
				if(OPERATION_UPDATE.equals(pervious)){
					step++;
				}
			}else if(OPERATION_DELETE.equals(in.toUpperCase())
					||OPERATION_DELETE.substring(0, 1).equals(in.toUpperCase())
					||OPERATION_DELETE.equals(pervious)){
				pervious=OPERATION_DELETE;
				if(1==step){
					System.out.println("请输入要删除的联系人ID：");
				}else if(2==step){
					Integer id=null;
					try {
						id = Integer.valueOf(in);
						try {
							action.del(id);
							step=1;
							System.out.println("删除联系人信息成功");
						} catch (Exception e) {
							System.out.println("删除联系人信息失败");
						}
					} catch (Exception e) {
						System.out.println("请输入正确的女神ID：");
						step=1;
					}
				}
				if(OPERATION_DELETE.equals(pervious)){
					step++;
				}
			}else if(OPERATION_SEARCH.equals(in.toUpperCase())
					||OPERATION_SEARCH.substring(0, 1).equals(in.toUpperCase())
					||OPERATION_SEARCH.equals(pervious)){
				pervious=OPERATION_SEARCH;
				if(1==step){
					System.out.println("请输入要查询的联系人信息，支持姓名、手机号查询，如果两个参数都输入则用逗号分隔[name=xx,tel=xx]：");
				}else if(2==step){
					if(in!=null&&in!=""){
						List<Map<String, Object>> params=new ArrayList<Map<String,Object>>();
						Map<String, Object> param=null;
						String[] strs=in.split(",");
						for (int i = 0; i < strs.length; i++) {
							String[] strs_s=strs[i].split("=");
							param=new HashMap<String, Object>();
							param.put("name", strs_s[0]);
							param.put("rela", "=");
							param.put("value", "'"+strs_s[1]+"'");
							params.add(param);
						}
						List<Info> list=action.query(params);
						if(list!=null&&list.size()>0){
							for (Info goddess : list) {
								System.out.println(goddess.toString());
							}
						}else{
							System.out.println("没有查询到联系人信息。。。");
						}
						step=1;
					}
				}
				if(OPERATION_SEARCH.equals(pervious)){
					step++;
				}
			}
		}
	}

}
