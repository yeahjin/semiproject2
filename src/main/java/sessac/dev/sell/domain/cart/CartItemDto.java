package sessac.dev.sell.domain.cart;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemDto {
    private Integer id;          // 장바구니 항목 ID
    private Long memberId;      // 회원 ID
    private Integer itemId;     // 상품 ID
}
