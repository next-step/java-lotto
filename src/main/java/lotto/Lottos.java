package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {

    static final int AMOUNT_PER_LOTTO = 1000;
    private final List<Lotto> lottos;

    public Lottos(int purchaseAmount) {

        validate(purchaseAmount);
        lottos = IntStream.range(0, purchaseAmount / AMOUNT_PER_LOTTO).mapToObj(i -> new Lotto()).collect(Collectors.toList());
    }

    public int getLottoCount() {

        return lottos.size();
    }

    private void validate(int purchaseAmount) {

        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("로또를 구매할 수 없습니다. 구매금액=" + purchaseAmount);
        }
    }

    @Override
    public String toString() {

        return lottos.stream()
                .map(Lotto::toString)
                .reduce((lotto1, lotto2) -> lotto1 + "\n" + lotto2)
                .orElseThrow(IllegalStateException::new);
    }
}
