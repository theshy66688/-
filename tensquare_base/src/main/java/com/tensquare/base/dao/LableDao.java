package com.tensquare.base.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tensquare.base.pojo.Label;

public interface LableDao extends JpaRepository<Label, String>,JpaSpecificationExecutor<Label>  {

	
}
