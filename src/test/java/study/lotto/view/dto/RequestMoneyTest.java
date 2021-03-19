package study.lotto.view.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.lotto.exception.LottoException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RequestMoneyTest {

    @ParameterizedTest(name = "{0} == {1} 금액 입력 시, 비교 입력 값 비교 테스트 ")
    @CsvSource(value = {"1000, 1000"})
    void requestMoney_금액_입력_값에_따라_로또_갯수_반환_테스트(int given, int expected) {
        RequestMoney money = new RequestMoney(given);

        assertThat(money).isEqualTo(new RequestMoney(expected));
    }

    @ParameterizedTest(name = "{0} 입력 시 로또 금액에 부족하여 예외 발생")
    @CsvSource(value = "999")
    void requestMoney_금액_예외처리(int given) {
        assertThatExceptionOfType(LottoException.class)
                .isThrownBy(() -> {
                    new RequestMoney(given);
                });
    }

    @DisplayName("금액에 따른 로또 갯수 확인 테스트")
    @Test
    void divideMoneyByPrice_금액에_따른_전체_로또_갯수() {
        RequestMoney money = new RequestMoney(1000);
        int lottoCount = money.divideMoneyByPrice();
        assertThat(lottoCount).isEqualTo(1);
    }
}
