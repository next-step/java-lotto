package lotto.domain;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class LottoNumberTest {

    @Test
    @DisplayName("주어진 수로 로또가 생성되는지 테스트")
    public void createLottoNumber() {
        // given
        int number = 1;

        // when
        LottoNumber lottoNumber = new LottoNumber(number);

        // then
        assertThat(lottoNumber.getLottoNumber()).isEqualTo(number);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "47"})
    @DisplayName("범위 밖의 수로 로또번호 생성시 오류가 발생되는지 테스트")
    public void createLottoNumberOccurredException(String input) {
        // given
        int number = Integer.parseInt(input);

        // when
        Throwable throwable = catchThrowable(() -> {
            new LottoNumber(number);
        });

        // then
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("로또 숫자는 1 ~ 46 사이의 숫자만 가능합니다.");
    }
}
