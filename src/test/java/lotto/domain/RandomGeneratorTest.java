package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RandomGeneratorTest {

    @Test
    void 랜덤_번호_생성_확인() {
        RandomNumberGeneration randoNumberGenerator = new RandomNumberGeneration();
        List<Integer> result = randoNumberGenerator.generate();
        Assertions.assertThat(result).hasSize(6);
    }
}