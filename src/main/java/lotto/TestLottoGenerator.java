package lotto;

import java.util.ArrayList;
import java.util.List;

public class TestLottoGenerator implements LottoGenerator {

    private final List<List<Integer>> numbers;

    public TestLottoGenerator(List<List<Integer>> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Lotto> generate(final int lottoBuyCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoBuyCount; i++) {
            lottos.add(buyLotto(i));
        }
        return lottos;
    }

    private Lotto buyLotto(final int index) {
        return Lotto.buy(numbers.get(index));
    }
}
