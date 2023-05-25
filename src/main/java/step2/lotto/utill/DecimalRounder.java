package step2.lotto.utill;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DecimalRounder {

	public static double roundToSecondsDecimal(double value) {
		BigDecimal decimal = new BigDecimal(value);
		decimal = decimal.setScale(2, RoundingMode.HALF_UP);

		return decimal.doubleValue();
	}
}
