package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberTest {

    @Test
    @DisplayName("랜덤번호 생성")
    public void randomNumber() {
        assertThat(RandomNumber.random()).isBetween(1, 45);
    }

    @Test
    @DisplayName("랜덤번호 6개 생성")
    public void sixRandomNumber() {
        assertThat(RandomNumber.sixRandomNumber().size()).isEqualTo(6);
    }

}
