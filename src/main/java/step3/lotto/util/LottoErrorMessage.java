package step3.lotto.util;

public class LottoErrorMessage {

    private static String LOTTO_RUNTIMEEXCEPTION = "정상적인 로또번호가 아닙니다.(1~45로 입력해주세요)";
    private static String LOTTO_NUMBERFORMATEXCEPTION = "문자를 입력하였습니다. 숫자를 입력해주세요";
    private static String LOTTO_INCORRECT_COUNT = "로도번호 갯수가 맞지 않습니다.";
    private static String LOTTO_NEGATIVEEXCEPTION = "음수가 들어올 수 없습니다.";
    private static String LOTTO_AMOUNT_CHECK = "로또구매 금액은 1000원이상 입력해야됩니다.";
    private static String LOTTO_RANK_EXCEPTION = "로또 랭크는 1등부터 4등만 입력할 수 있습니다.";
    private static String LOTTO_OVERLAP_CHECK = "로또 입력 숫자중에 중복값이 존재합니다.";
    private static String LOTTO_MAKE_COUNT_CHECK = "로또 번호는 6개만 만들 수 있습니다.";
    private static String LOTTO_BONUS_NUMBER_OVERLAP_CHECK = "로또번호와 보너스번호가 중복되었습니다.";

    private LottoErrorMessage() {
    }

    public static String getLottoRuntimeexception() {
        return LOTTO_RUNTIMEEXCEPTION;
    }

    public static String getLottoNumberformatexception() {
        return LOTTO_NUMBERFORMATEXCEPTION;
    }

    public static String getLottoIncorrectCount() {
        return LOTTO_INCORRECT_COUNT;
    }

    public static String getLottoNegativeexception() {
        return LOTTO_NEGATIVEEXCEPTION;
    }

    public static String getLottoAmountCheck() {
        return LOTTO_AMOUNT_CHECK;
    }

    public static String getLottoRankException() {
        return LOTTO_RANK_EXCEPTION;
    }

    public static String getLottoOverlapCheck() {
        return LOTTO_OVERLAP_CHECK;
    }

    public static String getLottoMakeCountCheck() {
        return LOTTO_MAKE_COUNT_CHECK;
    }

    public static String getLottoBonusNumberOverlapCheck() {
        return LOTTO_BONUS_NUMBER_OVERLAP_CHECK;
    }
}
