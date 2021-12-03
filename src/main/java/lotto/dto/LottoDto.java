package lotto.dto;

import lotto.domain.Lotto;

import java.util.List;

public class LottoDto {
    private List<Lotto> lottos;

    public LottoDto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
