package hello.core;


import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Scope(value="request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class ScopeLogger {

    private UUID uuid;
    private String url;
//
//    public ScopeLogger(){
//        this.uuid = UUID.randomUUID();
//    }

    public void setUrl(String url){
        this.url = url;
    }

    public String format(String msg){
        return String.format("[%s] %s %s", this.uuid.toString(), this.url, msg);
    }
    @PostConstruct
    public void init(){
        this.uuid = UUID.randomUUID();
        System.out.println(this.format("request scope bean created"));
    }

    @PreDestroy
     public void destroy(){
        System.out.println(this.format("request scope bean destroyed"));
    }

}
