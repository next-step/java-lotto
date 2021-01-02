package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberTest {

    private RandomNumber randomNumber;

    @BeforeEach
    void setUp() {
        randomNumber = new RandomNumber();
    }

    @Test
    @DisplayName("랜덤 숫자 6자리 확인")
    void createRandomNumbers() {
        assertThat(randomNumber.createRandomNumbers()).size().isEqualTo(6);
    }
}