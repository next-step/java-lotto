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
        assertThat(RandomNumbers.lottoNumbers().size()).isEqualTo(LottoNumbers.NUMBERS_LENGTH);
    }

    @DisplayName("최댓값은 45")
    @Test
    void maximum() {
        assertThat(RandomNumbers.lottoNumbers().get(RANDOM_NUMBERS_LAST_INDEX).value() <= new LottoNumber(LottoNumber.MAX).value()).isTrue();
    }


    @DisplayName("최솟값은 1")
    @Test
    void minimum() {
        assertThat(RandomNumbers.lottoNumbers().get(RANDOM_NUMBERS_FIRST_INDEX).value() >= new LottoNumber(LottoNumber.MIN).value()).isTrue();
    }

    @DisplayName("랜덤넘버는 45개의 static 값이다.")
    @Test
    void static45Values() {
        assertThat(RandomNumbers.candidates()).isSameAs(RandomNumbers.candidates());
    }
}
