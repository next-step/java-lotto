package lotto2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoAutoGeneratorTest {

    @DisplayName("로또 숫자를 랜덤하게 중복없이 6개 추출한다.")
    @Test
    public void testLottoNumberCreate() {
        LottoAutoGenerator lottoAutoGenerator = new LottoAutoGenerator();
        assertThat(lottoAutoGenerator.generateNumbers().size()).isSameAs(6);
    }
}
