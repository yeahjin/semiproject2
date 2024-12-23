package sessac.dev.sell.domain.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ItemDto {
    private Integer id;            // 상품 ID
    private String itemName;      // 상품 이름
    private int price;            // 가격
    private int stockNumber;      // 재고 수량
    private String itemDetail;     // 상품 상세 설명
}
