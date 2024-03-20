package lotto.domain;

public class LottoMatch {

    public static WinningInfo countNumbers(PickedLottoNumbers pickedNumbers, LottoNumber winningNumbers) {
        WinningInfo winningInfo = new WinningInfo();
        for (LottoNumber pickedNumber : pickedNumbers) {
            winningInfo.checkWinning(countNumber(pickedNumber, winningNumbers));
        }
        return winningInfo;
    }

    private static int countNumber(LottoNumber pickedNumber, LottoNumber winningNumbers) {
        int matchCount = 0;
        for (Integer winningNumber : winningNumbers) {
            matchCount += pickedNumber.contains(winningNumber);
        }
        return matchCount;
    }
}
