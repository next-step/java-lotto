import java.util.ArrayList;
import java.util.List;

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

    public WinningStatistics calculateWinningStatistics(List<Integer> winningNumbers) {
        throw new RuntimeException("not implemented yet");
    }
}
