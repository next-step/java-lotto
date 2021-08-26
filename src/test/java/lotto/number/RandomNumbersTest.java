package lotto.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("랜덤 넘버 리스트는")
public class RandomNumbersTest {

    @DisplayName("6개의 랜덤 넘버를 가진다.")
    @Test
    void generate6RandomNumbers() {
        int actual = RandomNumbers.generate().size();
        assertThat(actual).isEqualTo(6);
    }

    @DisplayName("45보다 큰 수는 가질 수 없다.")
    @Test
    void maximumIs45() {
        LottoNumber maxInRandomNumbers = RandomNumbers.generate().get(LottoNumbers.NUMBERS_LENGTH - 1);
        LottoNumber maxLottoNumber = new LottoNumber(Limit.MAX.getValue());
        assertThat(maxInRandomNumbers.getValue() <= maxLottoNumber.getValue()).isTrue();
    }

    @DisplayName("1보다 작은 수는 가질 수 없다.")
    @Test
    void minimumIs45() {
        LottoNumber minInRandomNumbers = RandomNumbers.generate().get(LottoNumbers.NUMBERS_LENGTH - 1);
        LottoNumber minLottoNumber = new LottoNumber(Limit.MIN.getValue());
        assertThat(minInRandomNumbers.getValue() >= minLottoNumber.getValue()).isTrue();
    }
}
