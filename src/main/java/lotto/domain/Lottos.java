package lotto.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos() {
        lottos = new LinkedList<>();
    }

    public static Lottos create(int size, Supplier<Lotto> supplier) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < size; i++) {
            lottos.add(supplier.get());
        }
        return lottos;
    }

    void add(Lotto lotto) {
        lottos.add(lotto);
    }

    private void increaseNumOfLotto(Result result, int count) {
        for (Jackpot jackpot : Jackpot.values()) {
            if (count == jackpot.getNumOfCorrected()) {
                result.increaseNumOfLotto(jackpot);
                break;
            }
        }
    }

    public Result getResult(Lotto winningLotto) {
        Result result = new Result();
        for (Lotto lotto : lottos) {
            int count = lotto.countSameNo(winningLotto);
            increaseNumOfLotto(result, count);
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto + "\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos.toString(), lottos1.lottos.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos.toString());
    }
}
