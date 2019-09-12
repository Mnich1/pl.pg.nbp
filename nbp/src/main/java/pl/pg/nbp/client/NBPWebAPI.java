package pl.pg.nbp.client;

import pl.pg.nbp.model.Currency;

import java.util.Date;

public interface NBPWebAPI {
    Currency getExchangeRateOfDollarPublishedFromDateToToday(Date date);
}
