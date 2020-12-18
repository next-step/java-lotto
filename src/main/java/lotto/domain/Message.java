package lotto.domain;

public interface Message {
	String START_BRACKET = "[";
	String END_BRACKET = "]";
	String COMMA = ",";
	String INPUT_MONEY = "구입금액을 입력해 주세요.";
	String INPUT_NUMBER = "숫자를 입력해 주세요.";
	String INVALID_POSITIVE_NUMBER = "양수가 아닙니다.";
	String PRINT_NUMBER_OF_LOTTO_PURCHASED = "개를 구매했습니다.";
	String INVALID_BUY_LOTTO = "최소 구매가능 금액은 1000원 입니다.";
	String INVALID_LOTTO_NUMBER_RANGE = "로또 번호는 1 ~ 45 사이의 값이어야 합니다.";
	String INVALID_EMPTY_LIST = "List가 비어 있습니다.";
	String INVALID_LOTTO_NUMBER_COUNT = "로또 숫자는 6개 이어야 합니다.";
	String INPUT_LAST_WIN_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
}
