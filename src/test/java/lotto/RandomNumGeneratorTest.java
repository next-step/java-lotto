package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumGeneratorTest {
    static final int LOTTO_SIZE = 6;

    RandomNumGenerator randomNumGenerator;

    @RepeatedTest(5)
    @DisplayName("중복되지 않는 6개의 숫자를 생성한다.")
    void lottoValidDuplicate() {
        randomNumGenerator = new RandomNumGenerator();
        assertThat(randomNumGenerator.generateNumber().size()).isEqualTo(LOTTO_SIZE);
    }
}