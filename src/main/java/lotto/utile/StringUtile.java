package lotto.utile;

public class StringUtile {

    public static int[] convertStringToInt(String winnerNumber) {
        LottoValidator.checkEmptyString(winnerNumber);

        String[] sWinnerNumber = winnerNumber.replace(" ", "").split(",");
        LottoValidator.checkLotOfNumber(sWinnerNumber);

        int[] iWinnerNumber = new int[6];
        for (int i = 0; i < sWinnerNumber.length; i++) {
            LottoValidator.checkIsNumber(sWinnerNumber[i]);
            LottoValidator.checkNumberRange(sWinnerNumber[i]);

            iWinnerNumber[i] = Integer.parseInt(sWinnerNumber[i]);
        }
        return iWinnerNumber;
    }

}
