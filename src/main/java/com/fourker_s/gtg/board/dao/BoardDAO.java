package com.fourker_s.gtg.board.dao;
import com.fourker_s.gtg.board.vo.BoardVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;
@Mapper("boardDAO")
public interface BoardDAO {
	public BoardVO showBoard(BoardVO vo);	//�Խñ� ��������
	public BoardVO writeBoard(BoardVO vo);	//����
	public BoardVO deleteBoard(BoardVO vo);	//����
}
