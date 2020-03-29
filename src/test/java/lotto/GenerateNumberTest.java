package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GenerateNumberTest {

    @DisplayName("생성가능한 로또 숫자를 생성한다.")
    @Test
    void canCreateNumbers() {
        GenerateNumber generateNumber = new GenerateNumber();
        assertThat(generateNumber.generateNumbers().size()).isSameAs(45);
    }

}
