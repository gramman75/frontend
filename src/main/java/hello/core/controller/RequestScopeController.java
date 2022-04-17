package hello.core.controller;

import hello.core.ScopeLogger;
import hello.core.service.ScopeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class RequestScopeController {

    private final ScopeLogger logger;
    private final ScopeService service;

    @RequestMapping("/scope")
    @ResponseBody
    public void requestScope(HttpServletRequest request){

        logger.setUrl(request.getRequestURL().toString());
        System.out.println(logger.format("controller"));
        service.logic(request);
    }

}
