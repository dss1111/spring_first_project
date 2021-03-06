
package com.fourker_s.gtg.board.web;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.fourker_s.gtg.board.vo.BoardVO;
import com.fourker_s.gtg.board.vo.PagingVO;
import com.fourker_s.gtg.login.vo.LoginVO;
import com.fourker_s.gtg.board.service.BoardService;
@Controller
public class BoardController {
	Logger LOGGER = LoggerFactory.getLogger(BoardController.class);
	@Resource(name="boardService")
	BoardService boardService;
	/*
	@RequestMapping(value="/board/boardMain.do")
	public String boardMain(Model model, BoardVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.debug("보드메인호출됨");
        model.addAttribute("boardList", boardService.showBoard(vo));
        
		return "/board/boardMain";
    }
    */
	@RequestMapping(value="/board/boardPaging.do")
	public String boardList(PagingVO vo, Model model, @RequestParam(value="nowPage", required=false)String nowPage, @RequestParam(value="cntPerPage", required=false)String cntPerPage) 
	{
		int total = boardService.countBoard();
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "10";
		}
		vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));	//전체,페이지 계산
		model.addAttribute("paging", vo);
		model.addAttribute("viewAll", boardService.selectBoard(vo));
		return "/board/boardPaging";
	}
	@RequestMapping(value="/board/boardView.do")
	public String boardView(Model model, @RequestParam(value="boardNum")String boardNum) 
	{
		BoardVO target=new BoardVO();
		target.setNum(Integer.parseInt(boardNum));
		boardService.viewCountUp(target);
		model.addAttribute("board",boardService.viewBoard(target));
		return "/board/boardView";
	}
	@RequestMapping(value="/board/boardWrite.do")
	public String write(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.debug("boardWrite호출됨");
		return "/board/boardWrite";
    }
	@RequestMapping(value="/board/boardWriteFunction.do")
	public String writeFunction(Model model, BoardVO vo,HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.debug("boardWriteFunc호출됨");
		HttpSession httpSession = request.getSession(true);
		LoginVO loginvo=(LoginVO)httpSession.getAttribute("loginvo");
		vo.setWriter(loginvo.getId());	//아이디로 작성자 저장
		vo.setCount(0);
		//////작성날짜//////
		Date from = new Date();
		SimpleDateFormat fm = new SimpleDateFormat("yyyy.MM.dd");	
		String to = fm.format(from);
		vo.setWdate(to);
        boardService.writeBoard(vo);
		return "/board/boardWriteFunction";
    }
	@RequestMapping(value="/board/boardDelete.do")
	public String delete(Model model, @RequestParam(value="boardNum")String boardNum, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.debug("boardDelete호출됨");
		HttpSession httpSession = request.getSession(true);
		LoginVO loginvo=(LoginVO)httpSession.getAttribute("loginvo");
		BoardVO target=new BoardVO();
		target.setNum(Integer.parseInt(boardNum));	//target = 해당번호의 게시글
        LOGGER.debug("번호:"+Integer.toString(target.getNum()));
		if(boardService.viewBoard(target).getWriter().equals(loginvo.getId()))// 게시글의 글쓴이와 로그인한 사용자와 같으면
		{
			boardService.deleteBoard(target);
	        LOGGER.debug("삭제했다");
			return "/board/boardDelete";
		}
		else
		{
	        LOGGER.debug("삭제못했다");
			return "/board/boardDelete"; 
		}
    }

}
