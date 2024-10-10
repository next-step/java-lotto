import model.LottoNumberGenerate;

import java.util.List;

public class MockLottoNumberGeneratorImpl implements LottoNumberGenerate {
    private List<List<Integer>> numbers = List.of(
            List.of(8, 21, 23, 41, 42, 43),
            List.of(3, 5, 6, 16, 32, 38)
    );

    @Override
    public List<List<Integer>> multiGenerate(int start, int end) {
        return numbers.subList(start, end);
    }

    @Override
    public List<Integer> generate() {
        return numbers.get(0);
    }
}
