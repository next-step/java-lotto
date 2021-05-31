package lottery.domain;

import lottery.domain.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    @Test
    @DisplayName("6자리의 랜덤숫자를 생성한다.")
    void generate_test() {
        //given
        RandomNumberGenerator generator = new RandomNumberGenerator();

        //when
        List<Integer> randomNumbers = generator.generate();

        //then
        assertThat(randomNumbers).hasSize(6);
    }
}
