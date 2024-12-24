package sessac.dev.sell.domain.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemMapper itemMapper;

    /**
     * 물건 저장
     * @param itemDto - 저장할 물건 정보
     */
    public void saveItem(ItemDto itemDto) {
        itemMapper.save(itemDto);
    }

    /**
     * 물건 상세정보 조회
     * @param id - 물건 ID
     * @return 물건 상세정보
     */
    public ItemDto findItemById(Integer id) {
        return itemMapper.findById(id);
    }

    /**
     * 모든 물건 리스트 조회
     *
     * @return 물건 리스트
     */
    public List<ItemDto> findAllItem(){

        return itemMapper.findAllItem();
    }

//    public Page<Map<String,Object>> findAllItem(Map<String,Object> paramMap, Pageable page){
//        paramMap.put("offset", page.getNumberOfPages());
//        paramMap.put("pageSize", page.)
//    }



    /**
     * 물건 삭제
     * @param id - 삭제할 물건 ID
     */
    public void deleteItemById(Integer id) {
        itemMapper.deleteById(id);
    }
}
