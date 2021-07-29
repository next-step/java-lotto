package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomNumbersTest {
    @DisplayName("1-45 사이의 랜덤값이 생성되어야 한다.")
    @RepeatedTest(45)
    void generateRandomInt(){
        RandomNumbers randomNumbers = new RandomNumbers();
        assertThat(randomNumbers.generateRandomInt()).isBetween(1,45);
    }

    @DisplayName("6개의 숫자들이 생성되어야 한다.")
    @Test
    void generateNumbers(){
        RandomNumbers randomNumbers = new RandomNumbers();
        assertThat(randomNumbers.generateNumbers().size()).isEqualTo(6);
    }

}