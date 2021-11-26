package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;


/**
 * @author han
 */
class LottoNumberTest {

    @Test
    @DisplayName("생성")
    void create() {
        LottoNumber byString = new LottoNumber("1");
        assertThat(byString.getNumber()).isEqualTo(1);

        LottoNumber byInt = new LottoNumber(1);
        assertThat(byInt.getNumber()).isEqualTo(1);
    }

    @Test
    @DisplayName("45 이상 값을 입력했을 경우 에러를 던진다.")
    void throwErrorIfExceedBound() {
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> new LottoNumber(46));
    }
}