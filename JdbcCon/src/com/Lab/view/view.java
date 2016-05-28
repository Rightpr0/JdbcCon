package com.Lab.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.Lab.action.InfoAction;
import com.Lab.model.Info;

public class view {
	private static final String CONTEXT="��ӭ��������ͨѶ¼��\n" +
			"�����Ǽ���ͨѶ¼�Ĺ����б�\n" +
			"[MAIN/M]:���˵�\n" +
			"[QUERY/Q]:�鿴ͨѶ¼��ȫ����Ϣ\n" +
			"[GET/G]:�鿴ĳλ��ϵ�˵���ϸ��Ϣ\n" +
			"[ADD/A]:�����ϵ����Ϣ\n" +
			"[UPDATE/U]:������ϵ����Ϣ\n" +
			"[DELETE/D]:ɾ����ϵ����Ϣ\n" +
			"[SEARCH/S]:��ѯ��ϵ����Ϣ(�����������ֻ�������ѯ)\n" +
			"[EXIT/E]:�˳� ����ͨѶ¼\n";

	
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
				System.out.println("���ѳɹ��˳�����ͨѶ¼");
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
					System.out.println("�������ѯ����ϵ��ID��");
				}else if(step>1){
					Integer id=null;
					Info g;
					try {
						id = Integer.valueOf(in);
						try {
							g = action.get(id);
							if(g==null){
								System.out.println("��ѯ��ϵ����Ϣʧ��");
							}else{
								System.out.println(g.toString());
							}
						} catch (Exception e) {
							System.out.println("��ѯ��ϵ����Ϣʧ��");
						}
					} catch (Exception e) {
						System.out.println("��������ȷ����ϵ��ID��");
					}
					
				}
				step++;
			}else if(OPERATION_ADD.equals(in.toUpperCase())
					||OPERATION_ADD.substring(0, 1).equals(in.toUpperCase())
					||OPERATION_ADD.equals(pervious)){
				pervious=OPERATION_ADD;
				if(1==step){
					System.out.println("��������ϵ�˵���Ϣ[����]��");
				}else if(2==step){
					go=new Info();
					go.setName(in);
					System.out.println("��������ϵ�˵���Ϣ[�Ա�]��");
				}else if(3==step){
					go.setSex(in);
					System.out.println("��������ϵ�˵���Ϣ[�绰]��");
				}else if(4==step){
					go.setTel(in);
				try {
					action.add(go);
				} catch (Exception e) {
					System.out.println("������ϵ����Ϣʧ��");
				}
					System.out.println("������ϵ����Ϣ�ɹ�");
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
					System.out.println("������Ҫ�޸ĵ���ϵ��ID��");
				}else if(2==step){
					Integer id=null;
					try {
						id = Integer.valueOf(in);
						try {
							go = action.get(id);
							if(go==null){
								System.out.println("��ѯŮ����ϵ��ʧ��");
								step=1;
							}
						} catch (Exception e) {
							System.out.println("��ѯ��ϵ����Ϣʧ��");
							step=1;
						}
					} catch (Exception e) {
						System.out.println("��������ȷ����ϵ��ID��");
						step=1;
					}
					System.out.println("�������µ���ϵ����Ϣ[����]��������޸ĸ�ֵ��������-1��");
				}else if(3==step){
					if(-1!=Integer.valueOf(in)){
						go.setName(in);
					}
					System.out.println("�������µ���ϵ����Ϣ[�Ա�]��������޸ĸ�ֵ��������-1��");
				}else if(4==step){
					if(-1!=Integer.valueOf(in)){
						go.setSex(in);
					}
					System.out.println("�������µ���ϵ����Ϣ[�ֻ���]��������޸ĸ�ֵ��������-1��");
				}else if(5==step){
					if(-1!=Integer.valueOf(in)){
						go.setTel(in);
					}
					try {
						action.edit(go);
					} catch (Exception e) {
						System.out.println("������ϵ����Ϣʧ��");
					}
					System.out.println("������ϵ����Ϣ�ɹ�");
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
					System.out.println("������Ҫɾ������ϵ��ID��");
				}else if(2==step){
					Integer id=null;
					try {
						id = Integer.valueOf(in);
						try {
							action.del(id);
							step=1;
							System.out.println("ɾ����ϵ����Ϣ�ɹ�");
						} catch (Exception e) {
							System.out.println("ɾ����ϵ����Ϣʧ��");
						}
					} catch (Exception e) {
						System.out.println("��������ȷ��Ů��ID��");
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
					System.out.println("������Ҫ��ѯ����ϵ����Ϣ��֧���������ֻ��Ų�ѯ����������������������ö��ŷָ�[name=xx,tel=xx]��");
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
							System.out.println("û�в�ѯ����ϵ����Ϣ������");
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
