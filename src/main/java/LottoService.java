import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LottoService {

    private static final int LOTTO_PRICE = 1000;
    private final IntegerArrayGenerator integerArrayGenerator;

    public LottoService(IntegerArrayGenerator integerArrayGenerator) {
        this.integerArrayGenerator = integerArrayGenerator;
    }

    public List<List<Integer>> buyLotto(int amount) {
        int count = amount / LOTTO_PRICE;
        List<List<Integer>> lottoList = new ArrayList<>(amount);
        for (int i = 0; i < count; i++) {
            lottoList.add(integerArrayGenerator.getIntegerArray());
        }
        return lottoList;
    }

    public WinningStatistics calculateWinningStatistics(List<Integer> winningNumbers, List<List<Integer>> lottoList) {
        WinningStatistics winningStatistics = new WinningStatistics();
        for (List<Integer> lotto : lottoList) {
            int matchCount = getMatchCount(winningNumbers, lotto);
            int originalCount = winningStatistics.getWinningMap().get(matchCount);
            winningStatistics.getWinningMap().replace(matchCount, ++originalCount);
        }
        return winningStatistics;
    }

    public int getMatchCount(List<Integer> winningNumbers, List<Integer> lotto) {
        Stream<Integer> matchStream = lotto.stream().filter(winningNumbers::contains);
        return (int) matchStream.count();
    }
}
