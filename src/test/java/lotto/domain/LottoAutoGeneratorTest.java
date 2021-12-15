package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoAutoGeneratorTest {

    void generate() {
        LottoGenerator lottoGenerator = new LottoAutoGenerator();

        Lotto lotto = lottoGenerator.generate();


    }

}
