package lotto.constants;

public class MessageConstant {

	//Common
	public static final String NEW_LINE = System.lineSeparator();
	public static final String INPUT_SHOULD_INTEGER = "자연수로 입력 해 주세요.";

	//LottoNumber
	public static final String OVER_NUMBER_RANGE = "로또 숫자의 범위를 초과했습니다.";

	//LottoGame
	public static final String NUMBER_COUNT_SHOULD_BE_N = "한 게임 당 %d개의 숫자를 골라야 합니다.";

	//StoreCounter
	public static final String PLEASE_INPUT_PURCHASING_PRICE = "구입금액을 입력해 주세요.";
	public static final String PURCHASED_N_MANUAL_N_AUTO = "수동으로 %d장, 자동으로 %d장을 구매했습니다.";
	public static final String PLEASE_INPUT_LAST_WEEK_PRIZE = "지난 주 당첨 번호를 입력해 주세요.";
	public static final String PRIZE_STATISTICS_HEADER = "당첨 통계"+NEW_LINE+"---------";
	public static final String PRIZE_EXPLAIN_FORMAT = "%d개 일치 (%d원)";
	public static final String SECOND_PRIZE_EXPLAIN_FORMAT = "%d개 일치, 보너스 볼 일치(%d원)";
	public static final String PRIZE_STATISTICS_FORMAT = "%s- %d개";
	public static final String RATE_OF_RETURN_FORMAT = "총 수익률은 %.2f입니다. (%s)";
	public static final String PLEASE_INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
	public static final String BONUS_NUMBER_SHOULD_NOT_CONTAINS_PRIZE_GAME = "보너스 번호는 당첨 번호에 포함되어 있지 않은 숫자여야 합니다.";
	public static final String PLEASE_INPUT_MANUAL_GAME_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
	public static final String PLEASE_INPUT_MANUAL_GAME_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";

	//PrizeInfo

}
