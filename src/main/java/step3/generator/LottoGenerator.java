package step3.generator;

import step3.model.Lotto;

import java.util.List;

public interface LottoGenerator {
    List<Lotto> generate(int money);
}
