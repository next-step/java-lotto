package lotto.domain;

public class LottoMatch {

    public static WinningInfo countNumbers(PickedLottoNumbers pickedNumbers, LottoNumbers winningNumbers) {
        WinningInfo winningInfo = new WinningInfo();
        for (LottoNumbers pickedNumber : pickedNumbers) {
            Rank rank = Rank.findRank(countNumber(pickedNumber, winningNumbers));
            winningInfo.saveWinningInfo(rank);
        }
        return winningInfo;
    }

    private static int countNumber(LottoNumbers pickedNumber, LottoNumbers winningNumbers) {
        int matchCount = 0;
        for (Integer winningNumber : winningNumbers) {
            matchCount += pickedNumber.contains(winningNumber);
        }
        return matchCount;
    }
}
