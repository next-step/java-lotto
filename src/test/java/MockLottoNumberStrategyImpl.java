import model.LottoNumberStrategy;

import java.util.List;

public class MockLottoNumberStrategyImpl implements LottoNumberStrategy {
    @Override
    public List<List<Integer>> create(int cnt) {
        List<List<Integer>> numbers = List.of(List.of(8, 21, 23, 41, 42, 43), List.of(3, 5, 6, 16, 32, 38));
        return numbers;
    }
}
