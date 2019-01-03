package com.admin.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import chok.devwork.BaseController;

@Controller
@RequestMapping("/error")
public class ErrorAction extends BaseController<Object>
{
	@RequestMapping("/401")
	public void error401 ()
	{
		result.setMsg(req.getAttribute("msg").toString());
		result.setSuccess(false);
		printJson(result);
	}
}
