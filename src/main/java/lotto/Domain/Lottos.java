package lotto.Domain;


import java.util.*;

public class Lottos {

    private final List<Lotto> lottoList;

    private Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public static Lottos init(List<Lotto> lottoList) {
        return new Lottos(lottoList);
    }

    public void add(Lotto lotto) {
        lottoList.add(lotto);
    }

    public Map<LottoGrade, Integer> match(WinningLotto winningNumber) {
        Map<LottoGrade, Integer> statistics = initLottoStatistics();
        for (Lotto lotto : lottoList) {
            LottoGrade matchGrade = lotto.match(winningNumber);
            statistics.put(matchGrade, statistics.get(matchGrade) + 1);
        }
        return statistics;
    }

    Map<LottoGrade, Integer> initLottoStatistics() {
        Map<LottoGrade, Integer> statistics = new HashMap<>();
        Arrays.stream(LottoGrade.values()).forEach(value -> {
            statistics.put(value, 0);
        });
        return statistics;
    }

    public Double revenueRate(Map<LottoGrade, Integer> matchCountMap) {
        double sumOfWinningLotto = 0.0;

        for (Map.Entry<LottoGrade, Integer> entry : matchCountMap.entrySet()) {
            sumOfWinningLotto += calculatePrize(entry);
        }

        return sumOfWinningLotto / (lottoList.size() * 1000);
    }

    double calculatePrize(Map.Entry<LottoGrade, Integer> entry) {
        if(entry.getKey().getPrize() <= 2) {
            return 0;
        }
        return entry.getKey().getPrize() * entry.getValue();
    }

    public List<Lotto> toList() {
        return Collections.unmodifiableList(lottoList);
    }
}
