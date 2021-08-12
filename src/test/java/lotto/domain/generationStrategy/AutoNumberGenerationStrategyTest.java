package lotto.domain.generationStrategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class AutoNumberGenerationStrategyTest {

    private static final int LIMIT_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    @DisplayName("6개의 숫자 반환")
    @Test
    void generateLottoNumber_6개_숫자() {
        NumberGenerationStrategy numberGenerationStrategy = new AutoNumberGenerationStrategy();
        assertThat(numberGenerationStrategy.generateLottoNumber().size()).isEqualTo(LIMIT_SIZE);
    }

    @DisplayName("1부터 45까지의 숫자 반환")
    @Test
    void generateLottoNumber_1부터_45까지_숫자() {
        NumberGenerationStrategy numberGenerationStrategy = new AutoNumberGenerationStrategy();
        for (int number : numberGenerationStrategy.generateLottoNumber()) {
            assertThat(number).isBetween(MIN_NUMBER, MAX_NUMBER);
        }
    }

}
