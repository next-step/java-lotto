package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoAutoGeneratorTest {

    @DisplayName("로또 숫자를 랜덤하게 중복없이 6개 추출한다.")
    @Test
    public void testLottoNumberCreate() {
        LottoAutoGenerator lottoAutoGenerator = new LottoAutoGenerator();
        assertThat(lottoAutoGenerator.getLottoNumbers().size()).isSameAs(6);
    }

    @DisplayName("로또 범위를 생성한다.")
    @Test
    void canCreateLottoNumbers() {
        LottoAutoGenerator lottoAutoGenerator = new LottoAutoGenerator();
        assertThat(lottoAutoGenerator.generateNumbers().size()).isSameAs(45);
    }
}
