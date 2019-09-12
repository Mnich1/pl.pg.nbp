package pl.pg.nbp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import pl.pg.nbp.framework.Framework;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class NbpApplication {

    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(NbpApplication.class, args);
    }

    @PostConstruct
    public void start() {
        context.getBean(Framework.class).startFramework();
    }

}
