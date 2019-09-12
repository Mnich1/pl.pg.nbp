package pl.pg.nbp.framework;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.pg.nbp.model.Currency;
import pl.pg.nbp.client.NBPWebAPI;
import pl.pg.nbp.viewer.Viewer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

@Component
public class Framework {
    @Autowired
    private NBPWebAPI nbpWebAPI;
    @Autowired
    private Viewer viewer;

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Framework.class);


    public void startFramework() {
        Date date = getDate();
        Currency currency = getCurrency(date);
        viewer.viewCurrency(currency);
    }

    private Currency getCurrency(Date date) {
        return nbpWebAPI.getExchangeRateOfDollarPublishedFromDateToToday(date);
    }

    private Date getDate() {

        try {
            System.out.println("Please enter starting date in format yyyy-MM-dd. Application will count currency rate from that date since today: ");
            Scanner sc = new Scanner(System.in);
            String startDate = sc.nextLine();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            if (isThisDateValid(startDate, dateFormat)) {
                return dateFormat.parse(startDate);
            } else {

                System.out.println("Proper date format is yyyy-MM-dd");
            }
        } catch (ParseException e) {
            logger.error(e.getMessage());
        }
        return getDate();
    }

    public boolean isThisDateValid(String dateToValidate, SimpleDateFormat sdf) {

        if (dateToValidate == null) {
            return false;
        }
        sdf.setLenient(false);
        try {
            Date date = sdf.parse(dateToValidate);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

}
