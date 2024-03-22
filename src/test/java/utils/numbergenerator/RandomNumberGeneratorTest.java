package utils.numbergenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    private List<Integer> numbers =  IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());;

    @Test
    void 랜덤번호_6자리_생성() {
        for (int i = 0; i < 100; i++) {
            RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
            List<Integer> numbers = randomNumberGenerator.generate();
            for (Integer number : numbers) {
                assertThat(number).isBetween(1, 45);
            }
        }
    }
}