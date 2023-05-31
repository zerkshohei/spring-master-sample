package login.index;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexApi {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
