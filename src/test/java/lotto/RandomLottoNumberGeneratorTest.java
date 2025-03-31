package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.LottoNumberGenerator;
import lotto.domain.RandomLottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomLottoNumberGeneratorTest {

    @DisplayName("임의 로또 번호 생성기는 6개의 번호를 생성한다.")
    @Test
    void lottoNumber() {
        LottoNumberGenerator generator = new RandomLottoNumberGenerator();
        assertThat(generator.generate()).hasSize(6);
    }

    @DisplayName("임의 로또 번호 생성기는가 생성한 번호는 1~45의 범위를 갖는다.")
    @Test
    void lottoNumberRange() {
        LottoNumberGenerator generator = new RandomLottoNumberGenerator();
        assertThat(generator.generate()).allSatisfy(number -> {
            assertThat(number).isBetween(1, 45);
        });
    }
}
