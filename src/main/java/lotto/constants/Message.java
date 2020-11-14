package lotto.constants;

public class Message {
  public static final String NEW_LINE = System.lineSeparator();
  public static final String INPUT_SHOULD_INTEGER = "자연수로 입력 해 주세요.";
  public static final String OVER_NUMBER_RANGE = "로또입력 범위안의 자연수로 입력 해 주세요.";
  public static final String INPUT_VALUE = "입력값을 입력해주세요.";

  public static final String NUMBER_COUNT_SHOULD_N = "로또 게임은 %d개의 숫자를 입력해야합니다.";
  public static final String INPUT_SHOULD_NOT_LESS_THAN_PRICE_PER_GAME = "최소 구입 금액은 %d원 이상입니다.";

  public static final String RATE_OF_RETURN_IS_NOT_NEGATIVE_NUMBER = "손익 비율은 음수가 될 수 없습니다.";
  public static final String PLEASE_INPUT_PURCHASING_PRICE = "구입금액을 입력해 주세요.";
  public static final String PURCHASED_N_COUNT = "%d개를 구매했습니다.";
  public static final String PLEASE_INPUT_LAST_WEEK_PRIZE = "지난 주 당첨 번호를 입력해 주세요.";
  public static final String PRIZE_STATISTICS_HEADER = "당첨 통계"+NEW_LINE+"---------";
  public static final String PRIZE_STATISTICS_FORMAT = "%d개 일치 (%d원)- %d개";
  public static final String RATE_OF_RETURN_FORMAT = "총 수익률은 %.2f입니다. (%s)";

  private Message() {}
}
