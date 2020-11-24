package step2.lotto.automatic.util;

public class LottoStep2ErrorMessage {

    private static String LOTTO_STEP2_RUNTIMEEXCEPTION = "정상적인 로또번호가 아닙니다.(1~45로 입력해주세요)";
    private static String LOTTO_STEP2_NUMBERFORMATEXCEPTION = "문자를 입력하였습니다. 숫자를 입력해주세요";
    private static String LOTTO_STEP2_INCORRECT_COUNT = "로도번호 갯수가 맞지 않습니다.";
    private static String LOTTO_STEP2_NEGATIVEEXCEPTION = "음수가 들어올 수 없습니다.";
    private static String LOTTO_STEP2_AMOUNT_CHECK = "로또구매 금액은 1000원이상 입력해야됩니다.";
    private static String LOTTO_STEP2_RANK_EXCEPTION = "로또 랭크는 1등부터 4등만 입력할 수 있습니다.";
    private static String LOTTO_STEP2_OVERLAP_CHECK = "로또 입력 숫자중에 중복값이 존재합니다.";
    private static String LOTTO_STEP2_MAKE_COUNT_CHECK = "로또 번호는 6개만 만들 수 있습니다.";

    private LottoStep2ErrorMessage() {

    }

    public static String getLottoStep2OverlapCheck() {
        return LOTTO_STEP2_OVERLAP_CHECK;
    }

    public static String getLottoStep2MakeCountCheck() {
        return LOTTO_STEP2_MAKE_COUNT_CHECK;
    }

    public static String getLottoStep2AmountCheck() {
        return LOTTO_STEP2_AMOUNT_CHECK;
    }

    public static String getLottoStep2Negativeexception() {
        return LOTTO_STEP2_NEGATIVEEXCEPTION;
    }

    public static String getLottoStep2Runtimeexception() {
        return LOTTO_STEP2_RUNTIMEEXCEPTION;
    }

    public static String getLottoStep2Numberformatexception() {
        return LOTTO_STEP2_NUMBERFORMATEXCEPTION;
    }

    public static String getLottoStep2IncorrectCount() {
        return LOTTO_STEP2_INCORRECT_COUNT;
    }

    public static String getLottoStep2RankException() {
        return LOTTO_STEP2_RANK_EXCEPTION;
    }
}
