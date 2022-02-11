package lotto.domain.generator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.lotto.Number;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoAutoGeneratorTest {

    private List<Number> numbers;

    @BeforeEach
    void setUp() {
        LottoAutoGenerator lottoAutoGenerator = new LottoAutoGenerator();
        numbers = lottoAutoGenerator.generateNumbers();
    }

    @DisplayName("자동 생성 유효성 검사 (개수 일치 여부)")
    @Test
    void checkValidRandomNumbers() {
        assertThat(numbers.size())
            .isEqualTo(LottoGenerator.LOTTO_NUMBERS);
    }

}
