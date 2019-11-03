package com.tensquare.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LableService;
import com.tensquare.entity.Result;
import com.tensquare.entity.StatusCode;

import java.util.List;

@RestController
@RequestMapping("/label")
@CrossOrigin
public class LabelController {

	@Autowired
	private LableService lableService;

	/*
	 * 条件查询
	 * */
	@PostMapping("/search")
	public Result search(@RequestBody Label label) {
		List<Label> list= lableService.search(label);
		return new Result(true, StatusCode.OK, "条件查询成功",list);
	}
	/*
	 * 查询所有
	 * */
	@GetMapping
	public Result finfAll() {
		return new Result(true, StatusCode.OK,"查询所有成功",lableService.findAll());
	}
	/*
	 * 查询一个
	 * */
	@GetMapping("/{id}")
	public Result findById(@PathVariable String id) {
		return new Result(true, StatusCode.OK, "查询一个成功", lableService.findById(id));
	}
	/*
	 * 保存一个
	 * */
	@PostMapping
	public Result save(@RequestBody Label label) {
		lableService.save(label);
		return new Result(true, StatusCode.OK, "添加成功");
	}
	/*
	 * 修改
	 * */
	@PutMapping("/{id}")
	public Result update(@PathVariable String id ,@RequestBody Label label) {
		label.setId(id);
		lableService.update(label);
		return new Result(true, StatusCode.OK, "修改成功");
	}
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable String id) {
		lableService.deleteById(id);
		return new Result(true, StatusCode.OK, "删除成功");
	}
}
