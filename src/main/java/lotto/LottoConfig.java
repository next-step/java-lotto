package lotto;

public class LottoConfig {
    static public final int LOTTO_SIZE = 6;
    static public final int LOTTO_START_NUMBER = 1;
    static public final int LOTTO_LAST_NUMBER = 45;
    static public final String LOTTO_SIZE_ERROR_MESSAGE = "로또의 갯수는 "+LOTTO_SIZE + "자이어야 합니다.";
    static public final String LOTTO_NUMBER_ERROR_MESSAGE = "로또번호는"+LOTTO_START_NUMBER+"과 " + LOTTO_LAST_NUMBER + "사이 숫자이어야 합니다.";
    static public final String LOTTO_NULL_MESSAGE = "로또에 null값을 넣을 수 없습니다.";

    static public final int LOTTO_PRICE = 1000;
    static public final String PURCHASE_AMOUNT_MINUS_ERROR_MESSAGE = "구입금액은 음수일 수 없습니다.";
}
