package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class RandomNumbersGeneratorTest {

    @Test
    @DisplayName("번호를 랜덤하게 6개 생성할 수 있다.")
    void generateRandomNumbersTest() {

        // when
        List<LottoNumber> numbers = RandomNumbersGenerator.generateNumbers();

        // then
        assertThat(numbers.size()).isEqualTo(6);
    }

    @Test
    @RepeatedTest(10)
    @DisplayName("랜덤으로 생성한 로또 번호가 1~45 사이어야 한다.")
    void generateNumbersRangeTest() {

        // given
        LottoNumber min = LottoNumber.of(1);
        LottoNumber max = LottoNumber.of(45);

        // when
        List<LottoNumber> result = RandomNumbersGenerator.generateNumbers();

        // then
        for (LottoNumber number : result) {
            assertThat(number).isGreaterThanOrEqualTo(min).isLessThanOrEqualTo(max);
        }
    }

}