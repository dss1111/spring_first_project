
package com.fourker_s.gtg.board.service;
import java.util.List;
import com.fourker_s.gtg.board.vo.BoardVO;
import com.fourker_s.gtg.board.vo.PagingVO;
public interface BoardService {
	public List<BoardVO> showBoard(BoardVO vo);	//��ü �Խñ� ��������
	public List<BoardVO> selectBoard(PagingVO vo);//����¡ ó���� �Խñ� ��������
	public int countBoard();//�Խñ� ������������
	public BoardVO writeBoard(BoardVO vo);//�Խñ� ����
	public BoardVO viewBoard(BoardVO vo);//�ش��ȣ�� �Խñ� ����
	public BoardVO viewCountUp(BoardVO vo);//��ȸ�� ����
}
