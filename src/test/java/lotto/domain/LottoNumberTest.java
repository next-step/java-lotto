package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("로또 번호 테스트")
class LottoNumberTest {

    @ParameterizedTest(name = "로또는 지정된 범위의 숫자(1~45)가 아니면 생성에 실패한다")
    @ValueSource(ints = {0, 46, 1004, -1004})
    void createLottoNumber_fail(int number) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoNumber(number))
                .withMessage("로또 번호는 1~45 사이의 숫자여야 합니다");
    }

    @ParameterizedTest(name = "로또 1부터 45까지의 숫자로 생성에 성공한다")
    @ValueSource(ints = {1, 10, 30, 45})
    void createLottoNumber_success(int number) {
        LottoNumber lottoNumber = new LottoNumber(number);

        Assertions.assertThat(number).isEqualTo(lottoNumber.findLottoNumber());
    }
}
