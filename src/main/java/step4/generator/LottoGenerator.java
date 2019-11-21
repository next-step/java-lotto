package step4.generator;

import step4.model.Lotto;

import java.util.List;

public interface LottoGenerator {
    List<Lotto> generate(int money);
}
