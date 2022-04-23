package lotto.model;

import lotto.model.lotto.LottoNumber;
import lotto.model.lotto.strategy.RandomGenerationStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class RandomGenerationStrategyTest {

    private final RandomGenerationStrategy randomGenerationStrategy = new RandomGenerationStrategy();

    @Test
    @DisplayName("램덤 로또 번호들을 생성한다")
    void createRandomNumber() {
        Set<LottoNumber> numbers = randomGenerationStrategy.generateLottoNumbers();
        assertThat(numbers).hasSize(6);
    }

}