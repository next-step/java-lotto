package lotto.domain;

import java.util.List;

public class ManualLottoNumberGenerator implements LottoNumberGenerator {

    @Override
    public List<Lotto> generateLottoNumber(List<Lotto> lottos, int lottoCount) {
        return lottos;
    }
}
