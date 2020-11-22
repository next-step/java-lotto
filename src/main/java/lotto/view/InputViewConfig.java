package lotto.view;

public class InputViewConfig {

    public static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요.\n";
    public static final String INPUT_LOTTO_MANUAL_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.\n";
    public static final String INPUT_LOTTO_MANUAL_NUMBER_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.\n";
    public static final String INPUT_LOTTO_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.\n";
    public static final String NUMBER_REGEX = "^[0-9]+";
    public static final String INPUT_BONUS_BALL_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.\n";
    public static final String INPUT_EMPTY_ERROR_MESSAGE = "오류:: 로또 번호에 빈값을 넣을 수 없습니다.\n";
    public static final String PRICE_CHECK_ERROR_MESSAGE = "오류:: 로또 최소 구매액은 1000원 입니다, 1000원 단위로 입력하십시오. \n";
    public static final String INPUT_ARRAY_SIZE_ERROR_MESSAGE = "오류:: 로또 번호는 숫자 6개를 입력해야 합니다.\n";
    public static final String BONUS_NUMBER_CHECK_ERROR_MESSAGE = "오류:: 보너스 볼은 1부터 45까지 입니다. \n";
    public static final String LOTTO_COUNT_CHECK_ERROR_MESSAGE = "오류:: 로또 개수는 양수만 입력 가능합니다 \n";

    private InputViewConfig() {}
}
