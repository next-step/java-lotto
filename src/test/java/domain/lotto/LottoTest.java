package domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

class LottoTest {

    @DisplayName("로또 번호가 1~45 사이의 숫자가 아닌 경우 IllegalArgumentException throw")
    @ValueSource(ints = {0, 46})
    @ParameterizedTest
    void createLottoException(int outOfRangeNumber) {
        // given
        List<Integer> lottoNumber = List.of(1,2,3,4,5,outOfRangeNumber);

        // when
        Assertions.assertThatThrownBy(() -> new Lotto(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 중복된 경우 IllegalArgumentException throw")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,1})
    void createLottoExceptionWithDuplicatedNumber(int duplicatedNumber) {
        // given
        List<Integer> lottoNumber = List.of(1,2,3,4,5,duplicatedNumber);

        // when
        Assertions.assertThatThrownBy(() -> new Lotto(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 6개가 아닌 경우 IllegalArgumentException throw")
    @Test
    void createLottoExceptionWithNotSixNumbers() {
        // given
        List<Integer> lottoNumber = List.of(1,2,3,4,5);

        // when
        Assertions.assertThatThrownBy(() -> new Lotto(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}