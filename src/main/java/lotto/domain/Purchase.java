package lotto.domain;

import lotto.strategy.NumberStrategy;
import lotto.strategy.RandomNumberStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class Purchase {

    private List<Lotto> lottos;

    public Purchase(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> lottos() {
        return lottos;
    }

    public int lottosSize() {
        return lottos.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(lottos.size());
        sb.append("개를 구매했습니다.\n");
        sb.append(toStringLottos());

        return sb.toString();
    }

    private String toStringLottos() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
