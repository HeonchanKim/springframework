package com.example.ex02.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ex02.domain.vo.InfoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/ex/*")
@Log4j
public class SampleController {
	
	@RequestMapping(value="/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public void basic(HttpServletRequest req) {
		
		log.info("basic...." + req.getMethod());
	}
	
	@RequestMapping
	public void basic2() {
		log.info("basic2.......");
	}
	
	@GetMapping("/basicOnlyGet")
	public void basic3() {
		log.info("basic3.......only get");
	}
	
	@GetMapping("/ex01")
	//외부에서 전달된 파라미터를 매개변수 필드명과 자동으로 매핑한다.
	public void ex01(InfoDTO infoDTO) {
		log.info("ex01......" + infoDTO.getName() + ", " + infoDTO.getAge());
	}
	
	@GetMapping("ex02")
	//외부에서 전달된 파라미터의 이름과 매개변수가 다를 경우 @RequestParam을 사용하여 어디로 전달받을 지 알려준다.
	public void ex02(@RequestParam("data1") String name, @RequestParam("data2") int age) {
		log.info("ex02...." + name + ", " + age);
	}
	
	@GetMapping("/ex03")
	public String ex03(@RequestParam("data") ArrayList<String> datas) {
		log.info("datas: " + datas);
		return "ex03";
	}
	
	
	
}
