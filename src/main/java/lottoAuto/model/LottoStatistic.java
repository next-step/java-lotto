package lottoAuto.model;

import java.util.*;
import java.util.stream.Collectors;

public class LottoStatistic {
    private List<Lotto> userLottos;
    private Lotto winningLotto;
    private int bonus;

    public LottoStatistic(Lottos userLottos, Lotto winningLotto, int bonus) {
        this.userLottos = userLottos.getLotto();
        this.winningLotto = winningLotto;
        this.bonus = bonus;
    }

    public Map<Rank, Long> getStatistic() {
        LottoResults lottoResults = new LottoResults();

        for (Lotto userLotto : userLottos) {
            LottoResult lottoResult = new LottoResult(getCount(userLotto.getNumbers(), winningLotto.getNumbers()), hasBonus(userLotto.getNumbers(), bonus));
            lottoResults.add(lottoResult);
        }

        return lottoResults.getLottoResult().stream()
                .collect(Collectors.groupingBy(x -> Rank.findByRank(x), Collectors.counting()));
    }

    private int getCount(List<Integer> userLottoNumbers, List<Integer> winningLottoNumbers) {
        int count = 0;
        for (int j = 0; j < winningLottoNumbers.size(); j++) {
            if (userLottoNumbers.contains(winningLottoNumbers.get(j))) {
                count++;
            }
        }
        return count;
    }

    private Boolean hasBonus(List<Integer> userLottoNumbers, int bonus) {

        return userLottoNumbers.contains(bonus);
    }

    public double getRevenue(int price, Map<Rank, Long> resultMap) {
        int sum = resultMap.entrySet().stream().mapToInt(rankLongEntry ->Rank.getPrize(rankLongEntry.getKey(),rankLongEntry.getValue())).sum();
        double revenue = sum / price;
        return revenue;
    }

}
