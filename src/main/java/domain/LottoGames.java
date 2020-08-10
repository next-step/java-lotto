package domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoGames {
    public static final int FIRST_WINNING_MONEY = 2000000000;
    public static final int SECOND_WINNING_MONEY = 1500000;
    public static final int THIRD_WINNING_MONEY = 50000;
    public static final int FORTH_WINNING_MONEY = 5000;
    public static final int NOTHING = 0;

    public static Map<Integer, Integer> winningMoneyMap;

    static {
        winningMoneyMap = initWinningMoneyMap();
    }

    private static Map<Integer, Integer> initWinningMoneyMap() {
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

    public static LottoGames of(int money, String winningNumberStr) {
        LottoMoney lottoMoney = new LottoMoney(money);
        List<LottoGame> lottoGameList = lottoMoney.generateLottoGame();
        List<Integer> winningNumberList = getWinningListFromString(winningNumberStr);
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningNumberList);

        return new LottoGames(lottoGameList, lottoMoney, lottoWinningNumbers);
    }

    private static List<Integer> getWinningListFromString(String winningNumberStr) {
        return Arrays.stream(winningNumberStr.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private final List<LottoGame> lottoGames;
    private final LottoMoney lottoMoney;
    private final LottoWinningNumbers lottoWinningNumbers;

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
        map.put(0, 0);
        map.put(1, 0);
        map.put(2, 0);
        map.put(3, 0);
        map.put(4, 0);
        map.put(5, 0);
        map.put(6, 0);
        return map;
    }

    public double getBenefitRate(Map<Integer, Integer> winningStatistics) {
        winningMoneyMap = initWinningMoneyMap();
        double winningMoney = 0;
        for (Map.Entry<Integer, Integer> entry : winningStatistics.entrySet()) {
            int benefit = winningMoneyMap.get(entry.getKey()) * entry.getValue();
            winningMoney += benefit;
        }

        return lottoMoney.getBenefitRate(winningMoney);
    }

    public List<LottoGame> getLottoGames() {
        return lottoGames;
    }

    public LottoWinningNumbers getLottoWinningNumbers() {
        return lottoWinningNumbers;
    }
}
