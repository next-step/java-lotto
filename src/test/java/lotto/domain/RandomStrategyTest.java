package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomStrategyTest {

    @Test
    @DisplayName("랜덤번호를 생성할때마다 6개씩 중복이 안되는지 확인")
    public void randomStrategyTest() {
        RandomStrategy strategy = new RandomStrategy();
        for( int gameCount = 0; gameCount < 5; gameCount++)  {
            Set<Integer> numbers = new HashSet<>();
            for( int lottoNumberCount = 0; lottoNumberCount < Lotto.NUMBER_COUNT; lottoNumberCount++) {
                numbers.add(strategy.generateNumber());
            }
            assertThat(numbers.size()).isEqualTo(Lotto.NUMBER_COUNT);
        }
    }
}
