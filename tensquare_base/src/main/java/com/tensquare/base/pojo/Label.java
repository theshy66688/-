package com.tensquare.base.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_label")
public class Label {

	@Id
   private String id;
   private String labelname;// 标签名称



   private String state;// 状态
   private Integer count;// 数量
   private String recommend;// 是否推荐
   private Integer fans;// 粉丝数
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getLabelname() {
	return labelname;
}
public void setLabelname(String labelname) {
	this.labelname = labelname;
}
public String getStatu() {
	return state;
}
public void setStatu(String statu) {
	this.state= statu;
}
public Integer getCount() {
	return count;
}
public void setCount(Integer count) {
	this.count = count;
}
public String getRecommend() {
	return recommend;
}
public void setRecommend(String recommend) {
	this.recommend = recommend;
}
public Integer getFans() {
	return fans;
}
public void setFans(Integer fans) {
	this.fans = fans;
}
  
}
