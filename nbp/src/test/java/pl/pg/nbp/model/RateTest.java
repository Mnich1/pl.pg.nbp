package pl.pg.nbp.model;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RateTest {

    @Test
    public void testSpread() {
        Rate rate = new Rate();
        rate.setAsk(new BigDecimal(3.8888));
        rate.setBid(new BigDecimal(3.7777));
        Assert.assertEquals(new BigDecimal(0.1111).setScale(4, RoundingMode.HALF_UP), rate.getSpread().setScale(4, RoundingMode.HALF_UP));
    }
}
