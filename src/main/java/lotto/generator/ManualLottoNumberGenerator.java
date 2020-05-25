package lotto.generator;

import lotto.domain.Lotto;

import java.util.List;

public class ManualLottoNumberGenerator implements LottoNumberGenerator {

    @Override
    public List<Lotto> generateLottoNumber(List<Lotto> lottos, int lottoCount) {
        return lottos;
    }
}
