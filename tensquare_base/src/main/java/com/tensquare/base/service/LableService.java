package com.tensquare.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tensquare.base.dao.LableDao;
import com.tensquare.base.pojo.Label;
import com.tensquare.util.IdWorker;



@Service
public class LableService {

	@Autowired
	private LableDao lableDao;

	@Autowired
	private IdWorker idWorker;

	/*
	 * 查询所有
	 * */
	public List<Label> findAll(){
		return lableDao.findAll();
	}
	/*
	 * 查询一个
	 * */
	public Label findById(String id) {
		return  lableDao.findById(id).get();
	}
	/*
	 * 新增一个
	 * */
	@Transactional
	public Label save(Label label) {

		label.setId(idWorker.nextId()+"");
		return lableDao.save(label);
	}
	/*
	 * 修改一个
	 * */
	@Transactional
	public Label update(Label label) {
		return lableDao.save(label);
	}
	/*
	 * 删除
	 * */
	@Transactional
	public void deleteById(String id) {
		lableDao.deleteById(id);
	}
}
