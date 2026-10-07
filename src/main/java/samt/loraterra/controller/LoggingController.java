package samt.loraterra.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*questo è fatto da AI*/
@Slf4j
@RestController
public class LoggingController {

    @RequestMapping("/")
    public String index() {

        log.info("Application accessed");
        log.warn("Warning example");
        log.error("Error example");

        return "Howdy!";
    }
}