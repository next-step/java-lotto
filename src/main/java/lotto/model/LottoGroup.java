package lotto.model;

import lotto.model.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public abstract class LottoGroup {
    protected List<Lotto> lottos;
    protected int count;

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void validate(int totalLottoCount) {
        if (count > totalLottoCount || count < 0) {
            throw new IllegalArgumentException("lotto count must be less than total lotto count and greater than 0.");
        }

        if (count != lottos.size()) {
            throw new IllegalArgumentException("The number of lotto entries is less than required.");
        }
    }

    @Override
    public String toString() {
        return lottos.stream()
                     .map(Lotto::toString)
                     .collect(Collectors.joining("\n"));
    }
}
