package step2;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.lotto.domain.LottoNumberRandomGenerator;

class LottoNumberRandomGeneratorTest {

    @Test
    @DisplayName("6개의 Lotto Numbers를 생성")
    void lottoNumbersCreateTest() {
        assertThat(new LottoNumberRandomGenerator().generateLottoNumbers()).hasSize(6);
    }
}