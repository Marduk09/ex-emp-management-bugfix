package jp.co.sample.emp_management.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 *アプリ内で処理できなかった例外をキャッチしエラーページへ遷移させる.
 * 
 * @author takara.miyazaki
 *
 */
public class GlobalExceptionHandler implements HandlerExceptionResolver{
	
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj, Exception e) {
		logger.error("システムエラーが発生しました。", e);
		return new ModelAndView("redirect:/common/maintenance");
	}
}
