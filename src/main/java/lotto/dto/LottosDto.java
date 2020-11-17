package lotto.dto;

import lotto.domain.Lottos;

public class LottosDto {
    private final Lottos lottos;

    public LottosDto(Lottos lottos) {
        this.lottos = lottos;
    }

    @Override
    public String toString() {
        return lottos.toString();
    }
}
