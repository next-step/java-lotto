package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLottoNumbersTest {
    private static final RandomLottoNumbers randomNumbers = new RandomLottoNumbers();

    @DisplayName("1-45 사이의 랜덤값이 생성되어야 한다.")
    @RepeatedTest(45)
    void generateRandomInt() {
        randomNumbers.generateNumbers().getLottoNumbers().forEach(i-> assertThat(i.getValue()).isBetween(1, 45));
    }
}