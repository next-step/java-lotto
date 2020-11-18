package lotto.dto;

import lotto.domain.Lottos;

public class LottosDto {
    private final Lottos lottos;

    public LottosDto(Lottos lottos) {
        this.lottos = lottos;
    }

    public Lottos getLottos() {
        return lottos;
    }
}
