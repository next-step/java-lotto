package lotto.model.dto;

import java.util.Collections;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;

public class LottosDto {

    private final List<Lotto> lottos;
    private final int lottoCount;

    LottosDto(final List<Lotto> lottos, final int lottoCount) {
        this.lottos = lottos;
        this.lottoCount = lottoCount;
    }

    public static LottosDto from(final Lottos lottos) {
        return new LottosDto(lottos.getLottos(), lottos.getLottoCount());
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(this.lottos);
    }

    public int getLottoCount() {
        return this.lottoCount;
    }
}
