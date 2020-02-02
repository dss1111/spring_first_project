package com.fourker_s.gtg.login.web;

import java.util.HashMap;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fourker_s.gtg.login.service.KakaoLoginService;
@Controller
public class KakaoController {
	Logger LOGGER = LoggerFactory.getLogger(KakaoController.class);
	@Resource(name="kakaoLoginService")
	KakaoLoginService kakaoLoginService;
	@RequestMapping(value="/main/kakaoLogin.do")
	public String kakaoLogin(@RequestParam("code")String code,Model model) throws Exception 
	{
        String access_Token=kakaoLoginService.getAccessToken(code);
        LOGGER.debug("�ڵ�="+code);
        LOGGER.debug("�ڵ�2="+access_Token);
        HashMap<String, Object> userInfo = kakaoLoginService.getUserInfo(access_Token);
        LOGGER.debug("����="+userInfo.get("id"));
        LOGGER.debug("����="+userInfo.get("nickname"));
		return "/main/kakaoLogin";
	}
}
