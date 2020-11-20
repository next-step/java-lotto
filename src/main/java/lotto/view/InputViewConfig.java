package lotto.view;

public class InputViewConfig {

    public static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요.\n";
    public static final String PRICE_CHECK_ERROR_MESSAGE = "오류:: 로또 구매 최소금액을 충족하지 않습니다. \n";
    public static final String INPUT_LOTTO_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.\n";
    public static final String INPUT_EMPTY_ERROR_MESSAGE = "오류:: 로또 번호에 빈값을 넣을 수 없습니다.\n";
    public static final String INPUT_ARRAY_SIZE_ERROR_MESSAGE = "오류:: 로또 번호는 숫자 6개를 입력해야 합니다.\n";
    public static final String NUMBER_REGEX = "^[0-9]+";

    private InputViewConfig() {}
}
