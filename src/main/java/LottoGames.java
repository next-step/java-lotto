import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoGames {
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
}
