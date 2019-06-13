package jp.co.sample.emp_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 共通コントローラ.
 * 
 * @author takara.miyazaki
 *
 */
@Controller
@RequestMapping("/common")
public class CommonController {
	
	/**
	 * エラー画面に遷移する.
	 * 
	 * @return エラー画面
	 */
	@RequestMapping("/maintenance")
	public String maintenance() {
		return "common/error";
	}

}
