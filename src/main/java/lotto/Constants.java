package lotto;

import java.math.BigDecimal;

public class Constants {
	public static final int LOTTO_MIN_NUMBER = 1;
	public static final int LOTTO_MAX_NUMBER = 45;
	public static final int LOTTO_NUMBERS_LENGTH = 6;
	public static final BigDecimal LOTTO_PRICE = BigDecimal.valueOf(1000);
	public static final String JOINING_DELIMITER = "\n";

	public static final String INPUT_MONEY_PRINT = "구매금액을 입력해 주세요.";
	public static final String INPUT_WINNING_NUMBER_PRINT = "지난 주 당첨 번호를 입력해 주세요.";
	public static final String INPUT_BONUS_BALL = "보너스 볼을 입력해 주세요.";
	public static final String INPUT_MANUAL_LOTTOS_NUMBER_TO_BUY = "수동으로 구매할 로또 수를 입력해 주세요.";

	public static String PRINT_NUMBER_OF_BOUGHT_LOTTOS(int auto, int manual) {
		return "수동으로 " + manual + "장, 자동으로 " + auto + "개를 구매했습니다.";
	}

	public static final String PRINT_STATISTICS = "당첨 통계\n---------";
	public static final String PRINT_MANUAL_LOTTOS = "수동으로 구매할 번호를 입력해 주세요.";

	public static String PRINT_PROFIT_RATE(float profitRate) {
		return "총 수익률은 " + profitRate + "입니다.";
	}
}
