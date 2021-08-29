package lotto.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("랜덤 넘버 리스트는")
class RandomNumbersTest {

    @DisplayName("생성시 지정된 길이만큼의 랜덤넘버를 가진다.")
    @ParameterizedTest(name = "길이 {0}")
    @ValueSource(ints = {4, 5, 6})
    void length(int length) {
        int actual = new RandomNumbers(1, 10, length).value().size();
        assertThat(actual).isEqualTo(length);
    }

    @DisplayName("랜덤 넘버의 최댓값은 생성자에 지정된 최댓값이다.")
    @Test
    void maximum() {
        LottoNumber maxInRandomNumbers = new RandomNumbers(1, 10, 10).value().get(9);
        LottoNumber maxLottoNumber = new LottoNumber(10);
        assertThat(maxInRandomNumbers).isEqualTo(maxLottoNumber);
    }


    @DisplayName("랜덤 넘버의 최솟값은 생성자에 지정된 최솟값이다")
    @Test
    void minimum() {
        LottoNumber minInRandomNumbers = new RandomNumbers(1, 10, 10).value().get(0);
        LottoNumber minLottoNumber = new LottoNumber(1);
        assertThat(minInRandomNumbers).isEqualTo(minLottoNumber);
    }
}
