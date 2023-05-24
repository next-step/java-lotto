package step2.lotto.utill;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DecimalRounder {

	public static double roundToSecondsDecimal(double value) {
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(2, RoundingMode.HALF_UP);

		return bd.doubleValue();
	}
}
