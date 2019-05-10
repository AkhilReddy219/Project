package com.frontauto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.autoback.dao.UserDao;



@Controller
public class HelloController 
{
	@Autowired
	UserDao userDao;
	@RequestMapping("/")
	public String showHome()
	{
		return "Register";
	}
}
