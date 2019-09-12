package pl.pg.nbp.viewer;

import org.springframework.stereotype.Component;
import pl.pg.nbp.model.Currency;

@Component
public class Viewer {

    public void viewCurrency(Currency currency) {
        System.out.println(currency.toString());
    }
}
