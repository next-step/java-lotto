package step2.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StringUtil {
  private static final int ROUNDING_SIZE = 2;


  private StringUtil() {
  }

  public static String doubleToStringWithRounding(Double number) {
    BigDecimal bigDecimal = new BigDecimal(number).setScale(ROUNDING_SIZE, RoundingMode.HALF_UP);
    double roundedYield = bigDecimal.doubleValue();
    return Double.toString(roundedYield);
  }
}
