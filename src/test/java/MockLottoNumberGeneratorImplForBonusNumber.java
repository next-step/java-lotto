import model.LottoNumberGenerate;

import java.util.List;

public class MockLottoNumberGeneratorImplForBonusNumber implements LottoNumberGenerate {
    private List<List<Integer>> numbers = List.of(
            List.of(1, 2, 3, 4, 6, 7)
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
