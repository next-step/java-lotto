package lotto.domain.number;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @ParameterizedTest
    @CsvSource({"1,1", "45,45"})
    void 숫자_1_45_사이로_인스턴스_정상_생성(int number, String numberString) {
        assertThat(new LottoNumber(number)).isEqualTo(new LottoNumber(numberString));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46, -1})
    void 숫자_1_45_사이_아니면_인스턴스_생성시_예외발생(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(number));
    }
}
