package com.tensquare.entity;

import java.util.List;

/**
 * 封装分页数据
 * @author Johnny.Chen
 *
 * @param <T> 当前页对象类型
 */
public class PageResult<T> {
	
	private long total;
	private List<T> rows;
	
	public PageResult(long total, List<T> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	public PageResult() {
		super();
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
