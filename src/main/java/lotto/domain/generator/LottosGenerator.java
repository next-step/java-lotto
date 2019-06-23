package lotto.domain.generator;

import lotto.domain.Lotto;

import java.util.List;

public interface LottosGenerator {

    List<Lotto> generate(int lottoCount);
}
