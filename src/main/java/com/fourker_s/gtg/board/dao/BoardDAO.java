
package com.fourker_s.gtg.board.dao;
import java.util.List;
import com.fourker_s.gtg.board.vo.BoardVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;
@Mapper("boardDAO")
public interface BoardDAO {
	public List<BoardVO> showBoard(BoardVO vo);	//�Խñ� �������� �Խñ� ����Ʈ ����
}
