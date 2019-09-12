package pl.pg.nbp.model;

import java.math.BigDecimal;

public class Rate {
    private String no;
    private String effectiveDate;
    private BigDecimal bid;
    private BigDecimal ask;


    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public BigDecimal getBid() {
        return bid;
    }

    public void setBid(BigDecimal bid) {
        this.bid = bid;
    }

    public BigDecimal getAsk() {
        return ask;
    }

    public void setAsk(BigDecimal ask) {
        this.ask = ask;
    }

    public BigDecimal getSpread() {
        return ask.subtract(bid);
    }

    @Override
    public String toString() {
        return "Rate{" +
                "no='" + no + '\'' +
                ", effectiveDate='" + effectiveDate + '\'' +
                ", bid=" + bid + '\'' +
                ", ask=" + ask + '\'' +
                ", spread = " + getSpread() + '\'' +
                "}\n";
    }
}
