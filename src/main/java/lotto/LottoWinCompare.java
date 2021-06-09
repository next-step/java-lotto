package lotto;

import java.util.List;

public class LottoWinCompare {
    public static LottoWin compareWinning(Lotto lotto, List<LottoNumber> winList, LottoNumber bonusNumber) {
        int matchNum = countWin(lotto.lottoNum(), winList);
        boolean matchBonus = lotto.lottoNum().stream().anyMatch(v -> v.value() == bonusNumber.value());
        return LottoWin.valueOf(matchNum, matchBonus);
    }

    private static int countWin(List<LottoNumber> lottoNumbers, List<LottoNumber> winList) {
        int winNum = 0;
        for (int i = 0; i < winList.size(); i++) {
            winNum += getWinCount(lottoNumbers, winList.get(i));
        }
        return winNum;
    }

    private static int getWinCount(List<LottoNumber> lottoNumbers, LottoNumber targetNum) {
        if (isWinNumber(lottoNumbers, targetNum)) {
            return 1;
        }
        return 0;
    }

    private static boolean isWinNumber(List<LottoNumber> lottoNumbers, LottoNumber targetNum) {
        return lottoNumbers.stream().anyMatch(v -> v.value() == targetNum.value());
    }
}
