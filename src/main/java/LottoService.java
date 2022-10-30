import java.util.List;

public class LottoService {

    private final IntegerArrayGenerator integerArrayGenerator;

    public LottoService(IntegerArrayGenerator integerArrayGenerator) {
        this.integerArrayGenerator = integerArrayGenerator;
    }

    public List<List<Integer>> buyLotto(int price) {
        throw new RuntimeException("not implemented yet");
    }

    public WinningStatistics calculateWinningStatistics(List<Integer> winningNumbers) {
        throw new RuntimeException("not implemented yet");
    }
}
