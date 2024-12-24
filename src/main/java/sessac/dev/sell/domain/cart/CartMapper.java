package sessac.dev.sell.domain.cart;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import sessac.dev.sell.domain.cart.CartItemDto;

import java.util.List;

@Mapper
public interface CartMapper {
    void insertCartItem(CartItemDto cartItemDto); // 장바구니에 상품 추가
    List<CartItemDto> selectCartItemsByMemberId(@Param("memberId") Long memberId); // 특정 회원의 장바구니 목록 조회
    void updateCartItemQuantity(@Param("memberId") Long memberId, @Param("itemId") Integer itemId, @Param("quantity") int quantity); // 수량 업데이트
    void deleteCartItem(@Param("memberId") Long memberId, @Param("itemId") Integer itemId); // 장바구니에서 상품 삭제
    void clearCart(@Param("memberId") Long memberId); // 장바구니 비우기
}
