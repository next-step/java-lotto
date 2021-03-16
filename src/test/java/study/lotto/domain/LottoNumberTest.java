package study.lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.lotto.exception.LottoException;

import static org.assertj.core.api.Assertions.*;

class LottoNumberTest {

    @ParameterizedTest(name = "{0} 입력 시 객체 비교 테스트")
    @CsvSource(value = {"1", "17", "45"})
    void createLottoNumber_정상_생성_테스트(int given) {
        // given
        LottoNumber lottoNumber = new LottoNumber(given);
        // when

        // then
        assertThat(lottoNumber).isEqualTo(new LottoNumber(given));
    }

    @ParameterizedTest(name = "{0} 입력 시 예외 발생 테스트")
    @CsvSource(value = {"0", "46"})
    void createLottoNumber_예외_테스트(int given) {
        assertThatExceptionOfType(LottoException.class)
                .isThrownBy(() -> {
                    new LottoNumber(given);
                });
    }
}
