package com.tensquare.base.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tensquare.base.dao.LableDao;
import com.tensquare.base.pojo.Label;
import com.tensquare.util.IdWorker;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


@Service
public class LableService {

	@Autowired
	private LableDao lableDao;

	@Autowired
	private IdWorker idWorker;
   /*
   * 条件查询
   * */
   public List<Label> search(Label label) {
      Specification<Label> specification= new Specification<Label>() {
           @Override
           public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder cb) {
               List<Predicate> preList = new ArrayList<>();
                  Predicate and1 =null;

               if(StringUtils.isNotBlank(label.getLabelname())){
                   Predicate labelname = cb.like(root.get("labelname"), "%" + label.getLabelname() + "%");
                   preList.add(labelname);
               }
                Predicate and2 =null;
               if (StringUtils.isNotBlank(label.getState())){
                   Predicate state = cb.equal(root.get("state"), label.getState());
                   preList.add(state);
               }
               Predicate[] predicates = new Predicate[preList.size()];
               preList.toArray(predicates);
               return cb.and(predicates);
           }
       };
      return lableDao.findAll(specification);
   }
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
		int i = 1/0;
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
