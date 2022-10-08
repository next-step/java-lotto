package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {

    @DisplayName("로또 자동 생성")
    @Test
    void generateLotto() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        Lotto lotto = lottoGenerator.generateLotto();
        Assertions.assertThat(lotto.getLotto()).hasSize(6);
    }
}
