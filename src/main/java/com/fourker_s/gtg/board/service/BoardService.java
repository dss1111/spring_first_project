
package com.fourker_s.gtg.board.service;
import java.util.List;
import com.fourker_s.gtg.board.vo.BoardVO;
import com.fourker_s.gtg.board.vo.PagingVO;
public interface BoardService {
	public List<BoardVO> showBoard(BoardVO vo);	//�Խñ� ��������
    // ����¡ ó�� ���� �޼���
	public List<BoardVO> selectBoard(PagingVO vo);
 
    // ��ü �Խñ� �� ���ϱ�
	public int countBoard();
    /*
    // �Խñ� �б� ����
    public BoardVO read(Integer bno) throws Exception;
    */
	public BoardVO writeBoard(BoardVO vo);
}
