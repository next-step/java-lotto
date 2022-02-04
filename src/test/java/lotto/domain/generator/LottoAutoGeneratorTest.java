package lotto.domain.generator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import lotto.domain.lotto.Numbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoAutoGeneratorTest {

    private List<Integer> numberList;

    @BeforeEach
    void setUp() {
        LottoAutoGenerator lottoAutoGenerator = new LottoAutoGenerator();
        Numbers numbers = lottoAutoGenerator.generateNumbers();
        numberList = numbers.get();
    }

    static boolean isInRange(final int number) {
        return (number >= LottoGenerator.START_NUMBER && number <= LottoGenerator.END_NUMBER);
    }

    @DisplayName("자동 생성 유효성 검사 (개수 일치 여부)")
    @Test
    void checkValidRandomNumbers() {
        assertThat(numberList.size()).isEqualTo(LottoGenerator.LOTTO_NUMBERS);
    }

    @DisplayName("자동 생성 유효성 검사 (범위 내 생성)")
    @Test
    void checkValidRandomNumbersInRange() {
        boolean isInRange = numberList.stream()
            .allMatch(LottoAutoGeneratorTest::isInRange);

        assertTrue(isInRange);
    }


}
