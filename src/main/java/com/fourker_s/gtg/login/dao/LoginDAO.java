package com.fourker_s.gtg.login.dao;

import com.fourker_s.gtg.login.vo.LoginVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;
@Mapper("loginDAO")
public interface LoginDAO {
	
	public LoginVO joinUser(LoginVO vo); //loginVO���̺� ���� ���
	
	public LoginVO checkUser(LoginVO vo);
	
	public LoginVO loginUser(LoginVO vo);
	
}
