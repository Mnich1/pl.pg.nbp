package pl.pg.nbp.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.pg.nbp.model.Currency;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component("NBPWebAPI")
public class NBPWebAPIImpl implements NBPWebAPI {
    @Value("${url.address}")
    private String address;
    @Value("${url.type}")
    private String format;

    public Currency getExchangeRateOfDollarPublishedFromDateToToday(Date date) {
        RestTemplate restTemplate = new RestTemplate();
        Currency currency = restTemplate.getForObject(getUri(date), Currency.class);
        return currency;
    }

    private String getUri(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String todayDate = dateFormat.format(new Date());
        return address + dateFormat.format(date) + "/" + todayDate + "/" + format;
    }
}
