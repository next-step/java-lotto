package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("로또숫자 테스트")
public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("범위밖의 로또숫자를 생성할 경우 예외발생 테스트")
    void createWrongRangeLottoNumber(int wrongNumber) {
        Assertions.assertThatThrownBy(() -> new LottoNumber(wrongNumber))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨번호와 일치하는지 여부를 테스트")
    void equals() {
        LottoNumber lottoNumber = new LottoNumber(1);
        Assertions.assertThat(lottoNumber.equals(new LottoNumber(1))).isTrue();
        Assertions.assertThat(lottoNumber.equals(new LottoNumber(2))).isFalse();
    }

}
