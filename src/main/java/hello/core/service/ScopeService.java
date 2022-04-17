package hello.core.service;

import hello.core.ScopeLogger;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
public class ScopeService {

    private final ScopeLogger logger;

    public void logic(HttpServletRequest request){

        System.out.println(logger.format("service"));

    }

}
