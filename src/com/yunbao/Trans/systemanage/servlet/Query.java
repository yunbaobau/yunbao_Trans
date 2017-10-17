package com.yunbao.Trans.systemanage.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunbao.translate.demo.*;

public class Query extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");//设置字符编码
		response.setCharacterEncoding("utf-8");
		
		String text = request.getParameter("text");//获取前台页面参数
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String result = getResult(text, from, to);
		response.getWriter().print(result);
	}
	public static String getResult(String text,String from,String to){
		String appid="20170414000044812";//你自己的APP_ID20170311000042048
		String securityKey="_57QLhsMQdaFkbumjo23";//你自己的密钥FTMfX96LmQhL2feHpVXG
		
		TransApi api = new TransApi(appid, securityKey); //创建TranApi 实例
		String result = api.getTransResult(text, from, to);
		return result; // 返回翻译的结果
	}
	//测试后台
		public static void main(String[] args) {
			String result = getResult("我是金鑫","zh","en");
			System.out.println(result);
		}
	
}
