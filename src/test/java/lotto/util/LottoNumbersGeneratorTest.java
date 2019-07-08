package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersGeneratorTest {


    @DisplayName("로또 번호가 1부터 45까지 나오는 지 확인한다.")
    @RepeatedTest(10)
    void generate() {
        LottoGenerator.generate().getNumbers().forEach(number -> assertThat(number.getValue()).isBetween(1, 45));
    }

}