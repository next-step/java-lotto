package lotto.domain.generator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import lotto.domain.lotto.Numbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AutoGeneratorTest {

    private static final int LOTTO_NUMBERS = 6;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;

    private List<Integer> numberList;

    @BeforeEach
    void setUp() {
        AutoGenerator autoGenerator = new AutoGenerator();
        Numbers numbers = autoGenerator.generateNumbers();
        numberList = numbers.get();
    }

    static boolean isInRange(int number) {
        return (number >= START_NUMBER && number <= END_NUMBER);
    }

    @DisplayName("자동 생성 유효성 검사 (개수 일치 여부)")
    @Test
    void checkValidRandomNumbers() {
        assertThat(numberList.size()).isEqualTo(LOTTO_NUMBERS);
    }

    @DisplayName("자동 생성 유효성 검사 (범위 내 생성)")
    @Test
    void checkValidRandomNumbersInRange() {
        boolean isInRange = numberList.stream()
            .allMatch(AutoGeneratorTest::isInRange);

        assertTrue(isInRange);
    }


}
