package pl.pg.nbp.framework;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class DateTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void testValidDatePositive() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = "2019-09-09";
        boolean isValid = new Framework().isThisDateValid(date, simpleDateFormat);
        Assert.assertTrue(isValid);
    }

    @Test
    public void testValidDateNegative() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = "09-09-2019";
        boolean isValid = new Framework().isThisDateValid(date, simpleDateFormat);
        Assert.assertFalse(isValid);
    }
}
