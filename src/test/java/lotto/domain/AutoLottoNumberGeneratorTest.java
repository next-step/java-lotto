package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class AutoLottoNumberGeneratorTest {

    @DisplayName("로또볼을 6개 뽑아서 반환한다")
    @Test
    void pickLottoBalls() {
        AutoLottoNumberGenerator lottoNumberGenerator = new AutoLottoNumberGenerator();

        Set<LottoNumber> pickedLottoBalls = lottoNumberGenerator.generate();

        assertThat(pickedLottoBalls.size()).isEqualTo(6);
    }

}
