package step3.model;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumbersGeneratorTest {

    private RandomNumbersGenerator randomNumbersGenerator;

    @BeforeEach
    void setting() {
        randomNumbersGenerator = new RandomNumbersGenerator();
    }

    @Test
    @DisplayName("중복된 숫자가 없는 로또 번호를 뽑는다")
    void createTest() {
        assertThat(randomNumbersGenerator.createNumbers().size()).isEqualTo(6);
    }

}
