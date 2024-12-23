package sessac.dev.sell.domain.item;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//import org.fluentd.logger.FluentLogger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sessac.dev.sell.domain.member.Gender;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
//@Slf4j
public class ProductController {

//    private final ItemService itemService;
    private final ProductInitializer productInitializer;
    private final HttpSession httpSession;

    @GetMapping("/products.do")
    public String showProducts(Model model) {
        // 상품 리스트를 모델에 추가
        model.addAttribute("items", productInitializer.getItems());
        return "item/product"; // templates/product.html을 반환
    }

    @GetMapping("/product/{id}")
    public String showProductDetail(@PathVariable Integer id, Model model, HttpServletRequest request) {
        ItemDto item = productInitializer.getItemById(id-1); // ID로 상품을 조회하는 메서드
        model.addAttribute("item", item);
        HttpSession session = request.getSession();

//        // 세션에서 가져온 정보
        String userId = (String) session.getAttribute("userId");
        String userName = (String) session.getAttribute("userName");
        String userGender = session.getAttribute("userGender").toString();
        int userAge = (int)session.getAttribute("userAge");


        // 로그 데이터 구성
//        Map<String, Object> logData = new HashMap<>();
//
//        logData.put("user_id", userId); // 실제 사용자 ID로 대체
//        logData.put("session_id", "session_abc123"); // 실제 세션 ID로 대체
//        logData.put("event_type", "product_click");
//        logData.put("price", 299000);
//        logData.put("user_name", userName);
//        logData.put("user_gender", userGender);
//        logData.put("user_age", userAge);
////
//        // 로그 기록
//        log.info(logData.toString());


        return "item/product-detail"; // templates/item/product-detail.html을 반환
    }

}
