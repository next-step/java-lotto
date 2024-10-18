package lotto.domain;

import java.math.BigDecimal;

public class LottoUnitAmount {
    public static final BigDecimal value = new BigDecimal(1000);

    public static BigDecimal getBigDecimalVal() {
        return value;
    }

    public static int getIntVal() {
        return value.intValue();
    }
}
