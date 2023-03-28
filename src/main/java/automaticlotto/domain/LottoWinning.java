package automaticlotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoWinning {

    public List<Integer> discriminateLottoNumber(Lotto lotto, Lotto winningLotto, List<Integer> lottoResult) {
        int winningNumberCount = 0;
        for (LottoNumber lottoNumber : lotto.getLottoNumbers()) {
            winningNumberCount = winningLotto.getLottoNumbers().stream()
                    .map(number -> number.getLottoNumber()).collect(Collectors.toList())
                    .contains(lottoNumber.getLottoNumber()) ? ++winningNumberCount : winningNumberCount;
        }
        lottoResult.set(winningNumberCount, lottoResult.get(winningNumberCount) + 1);
        return lottoResult;
    }

    public int rankLottoWinner(List<Integer> lottoResult) {
        int totalMoney = 0;
        for (int i = 3; i < lottoResult.size(); i++) {
            LottoRanking lottoRanking = lottoResult.get(i) > 0 ? LottoRanking.findLottoRanking(i) : LottoRanking.findLottoRanking(0);
            totalMoney += lottoRanking.getCompensation() * lottoResult.get(i);
        }
        return totalMoney;
    }

    public static String revenueRate(int purchaseAmount, int totalReward) {
        return String.format("%.2f", (double) totalReward / purchaseAmount);
    }
}
