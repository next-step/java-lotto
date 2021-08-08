package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLottoNumbersTest {
    @DisplayName("1-45 사이의 랜덤값이 생성되어야 한다.")
    @RepeatedTest(45)
    void generateRandomInt() {
        RandomLottoNumbers randomNumbers = new RandomLottoNumbers();
        assertThat(randomNumbers.generateNumbers().getLottoNumbers().get(0).getValue()).isBetween(1, 45);
    }
}