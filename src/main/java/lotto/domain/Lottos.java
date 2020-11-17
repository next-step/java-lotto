package lotto.domain;

import java.util.LinkedList;
import java.util.List;
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

    public Result getResult(WinningCondition condition) {
        Result result = new Result();
        for (Lotto lotto : lottos) {
            result.increaseNumOfLotto(condition, lotto);
        }
        return result;
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
