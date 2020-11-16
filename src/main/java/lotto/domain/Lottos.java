package lotto.domain;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

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
        // FIXME: forEach 를 사용하지 않고, 단번에 mapping 하는 방법은 없을까?
        Map<Rank, Integer> result = new HashMap<>();
        lottos.stream()
                .collect(
                        Collectors.groupingBy((Lotto lotto) -> lotto.getRank(winningLotto, bonus))
                ).entrySet()
                .stream()
                .forEach((entry) -> {
                    result.put(
                            entry.getKey(),
                            entry.getValue().size()
                    );
                });
        return new Result(result);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto + "\n");
        }
        return sb.toString();
    }
}
