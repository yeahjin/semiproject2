package sessac.dev.sell.domain.service;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServiceController {
    @GetMapping("/customer-support")
    public String customerSupport(){
        return "service/customer-support";
    }
}
