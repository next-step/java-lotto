package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberTest {

    @Test
    @DisplayName("랜덤번호 6개 생성")
    public void sixRandomNumber() {
        List<Integer> numbers = RandomNumber.bringNumber();
        assertThat(numbers.size()).isEqualTo(6);
    }
}
