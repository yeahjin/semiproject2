package sessac.dev.sell.domain.cart;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sessac.dev.sell.domain.cart.CartItemDto;
import sessac.dev.sell.domain.cart.CartMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private CartMapper cartMapper;

    public void addToCart(CartItemDto item) {
        cartMapper.insertCartItem(item);
    }

    public List<CartItemDto> getCartItems(Long memberId) {
        System.out.println(memberId);
        return cartMapper.selectCartItemsByMemberId(memberId);
    }

    public void updateCartItemQuantity(Long memberId, Integer itemId, int quantity) {
        cartMapper.updateCartItemQuantity(memberId, itemId, quantity);
    }

    public void deleteCartItem(Long memberId, Integer itemId) {
        cartMapper.deleteCartItem(memberId, itemId);
    }

    public void clearCart(Long memberId) {
        cartMapper.clearCart(memberId);
    }
}
