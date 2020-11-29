package lotto;

public interface Message {

    String VALIDATION_LOTTO_NUMBER_SIZE_MESSAGE = "로또 번호는 6개가 선택 되어야 합니다.";
    String VALIDATION_PRICE_LIMIT_MESSAGE = "1000원 이상을 투입 해주세요";
    String VALIDATION_PRICE_UNIT_MESSAGE = "1000원 단위로 투입 해주세요";

    String INPUT_PURCHASE_PRICE_MESSAGE = "구입 금액을 입력 해주세요.";
    String OUTPUT_PURCHASE_COUNT_MESSAGE = "개를 구매했습니다.";
    String INPUT_LAST_WEEKS_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
}
