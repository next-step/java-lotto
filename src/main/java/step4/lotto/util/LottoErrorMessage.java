package step4.lotto.util;

public class LottoErrorMessage {

    private static String LOTTO_RUNTIME_EXCEPTION = "정상적인 로또번호가 아닙니다.(1~45로 입력해주세요)";
    private static String LOTTO_NUMBER_FORMAT_EXCEPTION = "문자를 입력하였습니다. 숫자를 입력해주세요";
    private static String LOTTO_INCORRECT_COUNT = "로도번호 갯수가 맞지 않습니다.";
    private static String LOTTO_NEGATIVE_EXCEPTION = "음수가 들어올 수 없습니다.";
    private static String LOTTO_AMOUNT_CHECK = "로또구매 금액은 1000원이상 입력해야됩니다.";
    private static String LOTTO_RANK_EXCEPTION = "로또 랭크는 1등부터 4등만 입력할 수 있습니다.";
    private static String LOTTO_OVERLAP_CHECK = "로또 입력 숫자중에 중복값이 존재합니다.";
    private static String LOTTO_MAKE_COUNT_CHECK = "로또 번호는 6개만 만들 수 있습니다.";
    private static String LOTTO_BONUS_NUMBER_OVERLAP_CHECK = "로또번호와 보너스번호가 중복되었습니다.";
    private static String LOTTO_MANUAL_BUY_COUNT_CHECK = "수동구입한 로또 가격은 입금한 금액보다 클 수 없습니다.";
    private static String LOTTO_COMAPRE_MANUAL_COUNT_WITH_INPUT_LOTTO_NUMBER = "입력한 로또번호들의 갯수와 구매한 갯수가 다릅니다.";

    private LottoErrorMessage() {
    }

    public static String getLottoRuntimeexception() {
        return LOTTO_RUNTIME_EXCEPTION;
    }

    public static String getLottoNumberformatexception() {
        return LOTTO_NUMBER_FORMAT_EXCEPTION;
    }

    public static String getLottoIncorrectCount() {
        return LOTTO_INCORRECT_COUNT;
    }

    public static String getLottoNegativeexception() {
        return LOTTO_NEGATIVE_EXCEPTION;
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

    public static String getLottoBonusNumberOverlapCheck() {
        return LOTTO_BONUS_NUMBER_OVERLAP_CHECK;
    }

    public static String getLottoRuntimeException() {
        return LOTTO_RUNTIME_EXCEPTION;
    }

    public static String getLottoComapreManualCountWithInputLottoNumber() {
        return LOTTO_COMAPRE_MANUAL_COUNT_WITH_INPUT_LOTTO_NUMBER;
    }

    public static String getLottoManualBuyCountCheck() {
        return LOTTO_MANUAL_BUY_COUNT_CHECK;
    }


}
