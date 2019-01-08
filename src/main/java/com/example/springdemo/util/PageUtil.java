package com.example.springdemo.util;

import org.apache.commons.lang.StringUtils;

import java.util.Map;
import java.util.Set;


/***
 * 通用的分页工具
 * @author lyq
 *
 */
public class PageUtil {
	public static final int CURR_PAGE_NUM = 1;
	public static final int PAGE_SIZE = 20;
	public static final PageUtil DEFAULT = new PageUtil();
	/**
	 * 当前页码
	 */
	private int pageNum;
	/**
	 * 页显示数量
	 */
	private int pageSize;
	/**
	 * 总页数
	 */
	private int pageCount;
	/**
	 * 总条数
	 */
	private Long totalCount;

	public PageUtil() {
	   this.pageNum = CURR_PAGE_NUM;
	   this.pageSize = PAGE_SIZE;
	}

	public PageUtil(int pageNum, int pageSize, int pageCount) {
	   this.pageNum = pageNum;
	   this.pageSize = pageSize;
	   this.pageCount = pageCount;
	}
	
	public PageUtil(int pageNum, int pageSize, int pageCount, long totalCount) {
		this(pageNum, pageSize, pageCount);
		this.totalCount = totalCount;
	}

	public PageUtil(String pageNum, String pageSize) {
	   this.pageNum = StringUtils.isNotEmpty(pageNum)?Integer.valueOf(pageNum):CURR_PAGE_NUM;
	   this.pageSize = StringUtils.isNotEmpty(pageSize)?Integer.valueOf(pageSize):PAGE_SIZE;
	}

	/**
	 * paraMap是个参数集
	 * @param url
	 * @param paraMap
	 * @return
	 */
	public String getPageScript(String url,Map<String, ?> paraMap){
		if(this.pageCount<=1){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<div class=\"bodydiv\">");
		sb.append("<div class=\"splitpage\">");
		sb.append("</div>");
		sb.append("</div>");
		sb.append("<script>");
		sb.append("$(\".splitpage\").createPage({");
		sb.append(" pageCount:"+pageCount+",");
		sb.append(" current:"+pageNum+",");
		sb.append(" totalCount:"+totalCount+",");
		sb.append(" backFn:function(p){");
		sb.append("		$(\"#myPageNum\").val(p);");
		sb.append("		$(\"#myPageForm\").submit();");
		sb.append("}");
		sb.append("});");
		sb.append("</script>");
		sb.append("<form action=\""+url+"\" method=\"get\" id=\"myPageForm\" >");
		sb.append("<input type=\"hidden\" name=\"pageSize\" value=\""+pageSize+"\" />");
		sb.append("<input type=\"hidden\" name=\"pageNum\" id=\"myPageNum\" />");
		if(paraMap!=null){
			Set<String> keys = paraMap.keySet();
			for (String key : keys) {
					sb.append("<input type=\"hidden\" name=\""+key+"\" value=\""+paraMap.get(key)+"\" />");
			}
		}
		sb.append("</form>");
		return sb.toString();
	}

	public int getPageNum() {
		return pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

}
