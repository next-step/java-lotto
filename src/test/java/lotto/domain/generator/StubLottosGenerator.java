package lotto.domain.generator;

import lotto.domain.Lotto;

import java.util.List;

public class StubLottosGenerator implements LottosGenerator{

    private final List<Lotto> stubLottos;

    public StubLottosGenerator(List<Lotto> stubLottos) {

        this.stubLottos = stubLottos;
    }

    @Override
    public List<Lotto> generate(int lottoCount) {

        return stubLottos;
    }
}