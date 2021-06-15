package lottoAuto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResults {
    private List<LottoResult> lottoResults;
    private UserLottos userLottos;
    private WinningLotto winningUserLotto;
    private int bonusBall;

    public LottoResults(UserLottos userLottos, WinningLotto winningUserLotto, int bonusBall) {
        this.lottoResults = new ArrayList<>();
        this.userLottos = userLottos;
        this.winningUserLotto = winningUserLotto;
        this.bonusBall = bonusBall;

        getStatistic();
    }

    private void getStatistic() {
        for (UserLotto userLotto : userLottos.getUserLottoNumbers()) {
            LottoResult lottoResult = new LottoResult(getCount(userLotto.getLottoNumbers(), winningUserLotto.getWinningLottoNumbers()), hasBonus(userLotto.getLottoNumbers(), bonusBall));
            lottoResults.add(lottoResult);
        }
    }

    private int getCount(List<Integer> userLottoNumbers, List<Integer> winningLottoNumbers) {
        int count = 0;
        for (int i = 0; i < winningLottoNumbers.size(); i++) {
            if (userLottoNumbers.contains(winningLottoNumbers.get(i))) {
                count++;
            }
        }
        return count;
    }

    private Boolean hasBonus(List<Integer> userLottoNumbers, int bonus) {

        return userLottoNumbers.contains(bonus);
    }

    public Map<Rank, Long> lottoRankCounting() {
        return lottoResults.stream()
                .collect(Collectors.groupingBy(x -> Rank.findByRank(x), Collectors.counting()));
    }

    public BigDecimal getRevenue(int price, Map<Rank, Long> resultMap) {
        int sum = resultMap.entrySet().stream()
                .mapToInt(rankLongEntry ->Rank.calculatePrize(rankLongEntry.getKey(),rankLongEntry.getValue()))
                .sum()
                ;

        return new BigDecimal(String.valueOf(sum)).divide(new BigDecimal(String.valueOf(price)),2, RoundingMode.FLOOR);
    }

}
