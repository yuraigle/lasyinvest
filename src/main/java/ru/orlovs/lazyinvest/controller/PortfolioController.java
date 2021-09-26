package ru.orlovs.lazyinvest.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Log4j2
@RestController
@RequiredArgsConstructor
public class PortfolioController {

    @RequestMapping(value = "/api/portfolio-info/{mix}", method = RequestMethod.GET)
    public boolean info(
            @PathVariable String mix,
            @RequestParam(name = "reallocate", required = false, defaultValue = "3") Integer reallocate,
            @RequestParam(name = "d1", required = false, defaultValue = "2021-01-01") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate d1
    ) {
        log.info(mix);
        log.info(reallocate);
        log.info(d1.atStartOfDay().toString());
        return true;
    }

}
