package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @Test
    @DisplayName("같은 번호를 가진 LottoNumber는 동등한 관계이다.")
    void generateLottoNumberTest() {
        LottoNumber firstLottoNumber = new LottoNumber(1);
        LottoNumber secondLottoNumber = new LottoNumber(1);

        Assertions.assertThat(firstLottoNumber).isEqualTo(secondLottoNumber);
    }

    @ParameterizedTest
    @DisplayName("LottoNumber는 1~45까지의 사이가 아니면 생성할 수 없다.")
    @ValueSource(ints={0, 46})
    void checkLottoNumberRangeTest(int number) {
        Assertions.assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1부터 45 사이의");
    }
}
