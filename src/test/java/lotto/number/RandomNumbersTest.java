package lotto.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("랜덤 넘버 리스트:")
class RandomNumbersTest {

    public static final int RANDOM_NUMBERS_FIRST_INDEX = 0;
    public static final int RANDOM_NUMBERS_LAST_INDEX = 5;

    @DisplayName("랜덤넘버 6개")
    @Test
    void length() {
        assertThat(new RandomNumbers().value().size()).isEqualTo(LottoNumbers.NUMBERS_LENGTH);
    }

    @DisplayName("최댓값은 45")
    @Test
    void maximum() {
        assertThat(new RandomNumbers().value().get(RANDOM_NUMBERS_LAST_INDEX).value() <= new LottoNumber(LottoNumber.MAX).value()).isTrue();
    }


    @DisplayName("최솟값은 1")
    @Test
    void minimum() {
        assertThat(new RandomNumbers().value().get(RANDOM_NUMBERS_FIRST_INDEX).value() >= new LottoNumber(LottoNumber.MIN).value()).isTrue();
    }
}
