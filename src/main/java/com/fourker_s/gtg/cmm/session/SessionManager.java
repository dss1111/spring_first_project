package com.fourker_s.gtg.cmm.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fourker_s.gtg.login.vo.LoginVO;
public class SessionManager {

	private static final Logger LOGGER = LoggerFactory.getLogger(SessionManager.class);
	
    public static void setLoginInfo(HttpServletRequest request, LoginVO loginvo) {
        HttpSession session = request.getSession(true);
        if(session!=null&&loginvo!=null) {
            session.setAttribute("loginvo", loginvo);
            request.getSession().setMaxInactiveInterval(60*30);
        }
    }
    /**
     * ���ǿ��� �α��������� �����´�.
     *
     * @param request HttpServletRequest
     * @return �α�������
     */
    public static LoginVO getLoginInfo(HttpServletRequest request ) {
    	LoginVO loginvo = null;

        HttpSession session = request.getSession(false);
        if(session != null){
	        Object obj = session.getAttribute("loginvo");
	        if(obj!=null) loginvo = (LoginVO)obj;
        }
    	else LOGGER.debug("Session is null");
        return loginvo;
    }
    /**
     * ���ǿ� LoginInfoVO�� �����ϴ��� üũ
     *
     * @param request HttpServletRequest
     * @return true: �α��εȰ��, false: �α׾ƿ��Ȱ��
     */
    public static boolean isValidSession(HttpServletRequest request) {
        boolean isValid = false;

        LoginVO loginvo = SessionManager.getLoginInfo(request);
        if (loginvo != null) {
            isValid = true;
        }
        return isValid;
    }
}
