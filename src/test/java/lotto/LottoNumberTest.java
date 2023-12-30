package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.domain.LottoNumber;

public class LottoNumberTest {

    @Test
    @DisplayName("로또 번호가 1이하 ,45이상인 수면 exception을 발생시킨다.")
    void test1() {

        String expectingMessage = "0보다 크고, 46보다 작은 수를 입력해주세요";

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new LottoNumber(0))
            .withMessageMatching(expectingMessage);

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new LottoNumber(46))
            .withMessageMatching(expectingMessage);
    }
}
