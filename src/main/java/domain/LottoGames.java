package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoGames {
    public static LottoGameWinningMoneyMaps winningMoneyMap = new LottoGameWinningMoneyMaps();

    private final List<LottoGame> lottoGames;
    private final LottoMoney lottoMoney;
    private final LottoWinningNumbers lottoWinningNumbers;

    public static LottoGames of(int money, List<Integer> winningNumbers) {
        LottoMoney lottoMoney = new LottoMoney(money);
        List<LottoGame> lottoGameList = lottoMoney.generateLottoGame();
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningNumbers);

        return new LottoGames(lottoGameList, lottoMoney, lottoWinningNumbers);
    }

    public LottoGames(List<LottoGame> games, LottoMoney lottoMoney, LottoWinningNumbers lottoWinningNumbers) {
        this.lottoGames = games;
        this.lottoMoney = lottoMoney;
        this.lottoWinningNumbers = lottoWinningNumbers;
    }

    public Map<Integer, Integer> getWinningStatistics() {
        Map<Integer, Integer> map = initMap();

        for (LottoGame lottoGame : lottoGames) {
            Integer winningNumber = lottoWinningNumbers.getWinningNumberInLottoGame(lottoGame);
            Integer value = map.getOrDefault(winningNumber, 0) + 1;
            map.put(winningNumber, value);
        }

        return map;
    }

    private Map<Integer, Integer> initMap() {
        Map<Integer, Integer> map = new HashMap<>();
        IntStream.rangeClosed(0, 6).boxed()
                .forEach(e -> {
                    map.put(e, 0);
                });
        return map;
    }

    public double getBenefitRate(Map<Integer, Integer> winningStatistics) {
        double winningMoney = 0;
        for (Map.Entry<Integer, Integer> entry : winningStatistics.entrySet()) {
            int benefit = winningMoneyMap.getBenefit(entry.getKey(), entry.getValue());
            winningMoney += benefit;
        }

        return lottoMoney.getBenefitRate(winningMoney);
    }

    public List<LottoGame> getLottoGames() {
        return lottoGames;
    }
}
