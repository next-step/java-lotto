package step3;

public class LottoNo {

    static final int LOTTO_NUMBER_MIN = 1;
    static final int LOTTO_NUMBER_MAX = 45;

    public static void checkEachNumber(int eachLottoNumber) {
        if (eachLottoNumber > Lotto.LOTTO_NUMBER_MAX || Lotto.LOTTO_NUMBER_MIN < 1)
            throw new IllegalArgumentException("당첨번호와 보너스 볼은 " + Lotto.LOTTO_NUMBER_MIN + " ~ " + Lotto.LOTTO_NUMBER_MAX + "사이로 입력하셔야 합니다.");
    }

    public static void checkOverlapBonusNumber(int winningNumber) {
        if (winningNumber == Lotto.lottoBonusNumber)
            throw new IllegalArgumentException("입력 된 당첨번호 중에 보너스 번호와 중복되는 값이 있습니다.");
    }

    public static void checkBonusNumber(Lotto inputWinningNumberList) {
        checkEachNumber(Lotto.lottoBonusNumber);
        for (int winningNumber : Lotto.valueOf(inputWinningNumberList)) {
            checkOverlapBonusNumber(winningNumber);
        }
    }
}
