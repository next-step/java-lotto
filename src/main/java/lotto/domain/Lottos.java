package lotto.domain;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

// NOTE: Lotto 의 일급 컬렉션
public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int size, Supplier<Lotto> supplier) {
        lottos = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            lottos.add(supplier.get());
        }
    }

    public Result getResult(Lotto winningLotto, LottoNo bonus) {
        Map<Rank, Integer> result = new HashMap<>();
        for (Lotto lotto : lottos) {
            Rank rank = lotto.getRank(winningLotto, bonus);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return new Result(result);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
