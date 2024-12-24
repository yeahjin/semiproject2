package sessac.dev.sell.domain.item;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Mapper
public interface ItemMapper {
    /**
     * 물건 저장
     * @param params - 게시글 정보
     */
    void save(ItemDto params);

    /**
     * 물건 상세정보 조회
     * @param id - PK
     * @return 게시글 상세정보
     */
    ItemDto findById(Integer id);

    /**
     * 물건 리스트 조회
     * @return 게시글 리스트
     */
    List<ItemDto> findAllItem ();

    /**
     * 물건 게시글 수 카운팅
     * @return 게시글 수
     */
    int count();

    /**
     * 게시글 삭제
     * @param id - PK
     */
    void deleteById(Integer id);


}
