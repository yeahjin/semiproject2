package sessac.dev.sell.domain.cart;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sessac.dev.sell.domain.cart.CartItemDto;
import sessac.dev.sell.domain.cart.CartService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private CartService cartService;

    @PostMapping("/add/{itemId}")
    public String addToCart(@PathVariable Integer itemId, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("id");

        System.out.println(userId);
        System.out.println(itemId);

        CartItemDto cartItem = new CartItemDto();
        cartItem.setMemberId(userId);
        cartItem.setItemId(itemId);
        System.out.println(cartItem.getItemId());

        cartService.addToCart(cartItem); // 장바구니에 추가

        return "redirect:/cart?memberId=" + userId; // 장바구니 페이지로 리다이렉트
    }


    @GetMapping
    public void viewCart(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Long memberId = (Long) session.getAttribute("id");
        System.out.println(memberId);
        List<CartItemDto> cartItems = cartService.getCartItems(memberId);
//        model.addAttribute("cartItems", cartItems);
//        return "/cart/cart"; // 장바구니 화면
    }

    @PostMapping("/update")
    public String updateCartItem(@RequestParam Long memberId, @RequestParam Integer itemId, @RequestParam int quantity) {
        cartService.updateCartItemQuantity(memberId, itemId, quantity);
        return "redirect:/cart?memberId=" + memberId; // 장바구니 페이지로 리다이렉트
    }

    @PostMapping("/delete")
    public String deleteCartItem(@RequestParam Long memberId, @RequestParam Integer itemId) {
        cartService.deleteCartItem(memberId, itemId);
        return "redirect:/cart?memberId=" + memberId; // 장바구니 페이지로 리다이렉트
    }

    @PostMapping("/clear")
    public String clearCart(@RequestParam Long memberId) {
        cartService.clearCart(memberId);
        return "redirect:/cart?memberId=" + memberId; // 장바구니 페이지로 리다이렉트
    }
}
