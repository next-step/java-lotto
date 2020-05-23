package lotto.domain.fake;

import lotto.domain.AutoLottoNumberGenerator;
import lotto.domain.Lotto;

import java.util.List;

public class FakeAutoLottoNumberGenerator extends AutoLottoNumberGenerator {
    private List<Lotto> fakeLottos;

    public FakeAutoLottoNumberGenerator(List<Lotto> fakeLottos) {
        this.fakeLottos = fakeLottos;
    }

    @Override
    public List<Lotto> generateLottoNumber(List<Lotto> lottos, int lottoCount) {
        return fakeLottos;
    }
}
