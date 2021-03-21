package lotto.util;

import lotto.domain.Lottos;

import java.util.List;

public class LottosDto {

    private List<String> lottoResult;

    public LottosDto(Lottos lottos) {
        lottoResult = lottos.numbers();
    }

    public List<String > getLottos() {
        return lottoResult;
    }
}
