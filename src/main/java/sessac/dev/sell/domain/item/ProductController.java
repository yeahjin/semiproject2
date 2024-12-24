package sessac.dev.sell.domain.item;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//import org.fluentd.logger.FluentLogger;
import org.fluentd.logger.FluentLogger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sessac.dev.sell.common.MessageDto;
import sessac.dev.sell.domain.member.Gender;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ProductController {

//    private final ItemService itemService;
    private final ProductInitializer productInitializer;
    private final HttpSession httpSession;
    private static final Logger F_Logger = LoggerFactory.getLogger("fileLog");
    private static FluentLogger Log = FluentLogger.getLogger("app");
    private final ItemService itemService;

    @GetMapping("/products.do")
    public String showProducts(Model model) {
        // 상품 리스트를 모델에 추가
        model.addAttribute("items",itemService.findAllItem());
        return "item/product"; // templates/product.html을 반환
    }

    @GetMapping("/product/{id}")
    public String showProductDetail(@PathVariable Integer id, Model model, HttpServletRequest request) {
//        ItemDto item = productInitializer.getItemById(id-1); // ID로 상품을 조회하는 메서드
        ItemDto item = itemService.findItemById(id);
        model.addAttribute("item", item);
        HttpSession session = request.getSession();

//        // 세션에서 가져온 정보
        String userId = (String) session.getAttribute("userId");
        String userName = (String) session.getAttribute("userName");
        String userGender = session.getAttribute("userGender").toString();
        int userAge = (int)session.getAttribute("userAge");


        // 로그 데이터 구성
        Map<String, Object> logData = new HashMap<>();

        logData.put("user_id", userId); // 실제 사용자 ID로 대체
//        logData.put("session_id", "session_abc123"); // 실제 세션 ID로 대체
        logData.put("event_type", "product_click");
        logData.put("item_name", item.getItemName());
        logData.put("item_detail", item.getItemDetail());
        logData.put("price", item.getPrice());
        logData.put("user_name", userName);
        logData.put("user_gender", userGender);
        logData.put("user_age", userAge*(-1));

        // 로그 기록
//        log.info(logData.toString());
        F_Logger.debug(logData.toString());
        Log.log("follow", logData);


        return "item/product-detail"; // templates/item/product-detail.html을 반환
    }

    @PostMapping("/product/add")
    public String addProduct(final ItemDto params, Model model){
        itemService.saveItem(params);
        MessageDto message = new MessageDto("상품 업로드 완료되었습니다. ", "/product.do", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    @PostMapping("/product/delete.do")
    public String deleteProduct(@RequestParam final Integer id, Model model){
        itemService.deleteItemById(id);
        MessageDto message = new MessageDto("상품 삭제가 완료되었습니다.", "/product.do", RequestMethod.GET, null);
        return showMessageAndRedirect(message,model);
    }

    // 사용자에게 메시지를 전달하고, 페이지를 리다이렉트 한다.
    private String showMessageAndRedirect(final MessageDto params, Model model) {
        model.addAttribute("params", params);
        return "common/messageRedirect";
    }
}
