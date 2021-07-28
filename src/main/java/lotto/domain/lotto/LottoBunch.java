package lotto.domain.lotto;

import java.util.List;
import java.util.Objects;

public class LottoBunch {

    private final List<Lotto> lottos;

    private LottoBunch(List<Lotto> lottos) {
        validate(lottos);
        this.lottos = lottos;
    }

    public static LottoBunch of(List<Lotto> lottos) {
        return new LottoBunch(lottos);
    }

    private void validate(List<Lotto> lottos) {
        if (Objects.isNull(lottos) || lottos.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getAllLottoCount() {
        return lottos.size();
    }
}
