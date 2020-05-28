package lotto.domain.generator;

import lotto.domain.number.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LottoNumberGenerator 클래스 테스트")
class LottoNumberGeneratorTest {

    @DisplayName("1~45 사이의 무작위 값을 생성한다.")
    @Test
    void createNumbers() {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

        int numbers = lottoNumberGenerator.createNumbers();

        assertThat(numbers).isBetween(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE);
    }
}
