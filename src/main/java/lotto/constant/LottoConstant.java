package lotto.constant;

public class LottoConstant {

    // 출력용
    public static final String INPUT_BUY_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNER_NUMBERS_MESSAGE = "방송에서 뽑힌 당첨 번호 6개를 입력해 주세요. 쉼표(,)로 구분합니다.";
    public static final String RESULT_WINNER_RANK = "당첨 통계";
    public static final String RESULT_WINNER_LINE = "----------";

    // 로또 최소 , 최대
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;

    // 구매 금액
    public static final String BUY_AMOUNT_ERROR = "천원 이상 구매해주시길 바랍니다.";
    public static final String BUY_QUANTITY_MESSAGE = "개를 구매하셨습니다.";

    // 로또 번호 개수는 6개
    public static final int LOTTO_NUMBER_COUNT = 6;

    // 에러 메시지
    public static final String LOTTO_NUMBER_DUPLICATE_ERROR = "중복된 당첨 번호가 존재합니다.";
    public static final String LOTTO_NUMBER_COUNT_ERROR = "당첨 번호는 6개 입력해주세요.";
    public static final String LOTTO_NUMBER_SIZE_ERROR = "당첨 번호는 1 부터 45 이내 입력해주세요.";
}
