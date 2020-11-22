package lotto.domain;

public class LottoRuleConfig {

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int MAX_LOTTO_BALL_COUNT = 6;
    public static final int LOTTO_PRICE = 1_000;
    public static final String LOTTO_NUMBER_SEPARATOR = ",";
    public static final String UNDER_SIZE_NUMBERS = "오류:: 로또번호가 6개미만 입니다.\n";
    public static final String OVER_SIZE_NUMBERS = "오류:: 로또번호가 6개초과 입니다.\n";
    public static final String ERROR_LOTTO_NUMBER_SIZE = "오류:: 당첨 번호는 숫자 6개를 입력해야 합니다.\n";

    private LottoRuleConfig(){}
}
