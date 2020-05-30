package lotto.domain.generator;

import lotto.domain.number.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("LottoNumberGenerator 클래스 테스트")
class LottoNumberGeneratorTest {

    @DisplayName("1~45 사이의 무작위 값을 생성한다.")
    @Test
    void createNumbers() {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

        List<Integer> numbers = lottoNumberGenerator.getNumbers();

        assertAll(
                () -> assertThat(numbers.get(0)).isBetween(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE),
                () -> assertThat(numbers).hasSize(6)
        );
    }
}
