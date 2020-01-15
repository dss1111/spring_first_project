
package com.fourker_s.gtg.board.dao;
import java.util.List;
import com.fourker_s.gtg.board.vo.BoardVO;
import com.fourker_s.gtg.board.vo.PagingVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;
@Mapper("boardDAO")
public interface BoardDAO {
	public List<BoardVO> showBoard(BoardVO vo);	//�Խñ� ��ΰ�������  �Խñ� ����Ʈ ����
    // [ ����¡ ó���� ���� �޼��� ]
	public List<BoardVO> selectBoard(PagingVO vo);
 
    // ��ü �Խñ� �� ���ϱ�
	public int countBoard();
	public BoardVO writeBoard(BoardVO vo);
	public BoardVO viewBoard(BoardVO vo);	//Ư�� ��ȣ�� �Խñ� �ҷ�����
	public BoardVO viewCountUp(BoardVO vo);	//��ȸ�� ����
	public void deleteBoard(BoardVO vo);
}

