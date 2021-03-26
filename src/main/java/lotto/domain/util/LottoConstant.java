package lotto.domain.util;

public class LottoConstant {
    public static final int NUMBER_COUNT = 6; // 로또 당첨 숫자 개수
    public static final int START_NUMBER = 0; // 로또 시작 숫자 범위
    public static final int END_NUMBER = 45; // 로또 끝 숫자 범위
    public static final int PRICE=1000; // 로또 가격

    public static final String NUMBER_COUNT_EXCEPTION =
            String.format("로또 번호는 반드시 %d자리여야 합니다.", NUMBER_COUNT);
    public static final String MONEY_NEGATIVE_EXCEPTION = "금액은 음수일 수 없습니다.";
}
