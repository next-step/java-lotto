import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LottoGames {
    public static final int FIRST_WINNING_MONEY = 2000000000;
    public static final int SECOND_WINNING_MONEY = 1500000;
    public static final int THIRD_WINNING_MONEY = 50000;
    public static final int FORTH_WINNING_MONEY = 5000;
    public static final int NOTHING = 0;


    private final List<LottoGame> lottoGames;

    public LottoGames(List<LottoGame> games) {
        this.lottoGames = games;
    }

    public Map<Integer, Integer> getWinningStatistics(LottoWinningNumbers winningNumbers) {
        Map<Integer, Integer> map = initMap();

        for (LottoGame lottoGame : lottoGames) {
            Integer winningNumber = winningNumbers.getWinningNumberInLottoGame(lottoGame);
            Integer value = map.getOrDefault(winningNumber, 0) + 1;
            map.put(winningNumber, value);
        }

        return map;
    }

    private Map<Integer, Integer> initMap() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 0);
        map.put(2, 0);
        map.put(3, 0);
        map.put(4, 0);
        map.put(5, 0);
        map.put(6, 0);
        return map;
    }

    public double getBenefitRate(Map<Integer, Integer> winningStatistics, LottoMoney inputMoney) {
        Map<Integer, Integer> winningMoneyMap = initWinningMoneyMap();
        double winningMoney = 0;
        for (Map.Entry<Integer, Integer> entry : winningStatistics.entrySet()) {
            int benefit = winningMoneyMap.get(entry.getKey()) * entry.getValue();
            winningMoney += benefit;
        }

        return inputMoney.getBenefitRate(winningMoney);
    }

    private Map<Integer, Integer> initWinningMoneyMap() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, NOTHING);
        map.put(1, NOTHING);
        map.put(2, NOTHING);
        map.put(3, FORTH_WINNING_MONEY);
        map.put(4, THIRD_WINNING_MONEY);
        map.put(5, SECOND_WINNING_MONEY);
        map.put(6, FIRST_WINNING_MONEY);
        return map;
    }
}
