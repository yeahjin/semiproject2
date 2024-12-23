package sessac.dev.sell.domain.item;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductInitializer {

    private List<ItemDto> items = new ArrayList<>();

    @PostConstruct
    public void init() {
        items.add(new ItemDto(1, "상품 1", 10000, 50, "상품 1 상세 설명"));
        items.add(new ItemDto(2, "상품 2", 15000, 30, "상품 2 상세 설명"));
        items.add(new ItemDto(3, "상품 3", 20000, 20, "상품 3 상세 설명"));
        items.add(new ItemDto(4, "상품 4", 25000, 10, "상품 4 상세 설명"));
        items.add(new ItemDto(5, "상품 5", 30000, 5, "상품 5 상세 설명"));
        items.add(new ItemDto(6, "상품 6", 35000, 0, "상품 6 상세 설명"));
    }

    public List<ItemDto> getItems() {
        return items;
    }

    public ItemDto getItemById(Integer id) {
        return items.get(id);
    }
}