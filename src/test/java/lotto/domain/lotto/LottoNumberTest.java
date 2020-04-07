package lotto.domain;

import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoNumberRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @DisplayName("로또 번호를 입력받아 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    public void newLottoNumberTest(int number) {
        LottoNumber one = new LottoNumber(number);
        LottoNumber another = new LottoNumber(number);

        assertThat(one).isEqualTo(another);
    }

    @DisplayName("번호가 같으면 같은 객체로 인식한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    public void sameLottoNumberTest(int number) {
        LottoNumber one = new LottoNumber(number);
        LottoNumber another = new LottoNumber(number);

        assertThat(one.equals(another)).isTrue();
    }

    @DisplayName("로또 번호는 1 ~ 45 사이의 숫자만 가질 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    public void lottoNumberRangeTest(int number) {

        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(LottoNumberRangeException.class)
                .hasMessageContaining("로또 번호는 1~45 사이의 수만 가능합니다.");
    }

    @DisplayName("로또 번호의 인트 값을 호출할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    public void lottoNumberIntValueTest(int number) {
        LottoNumber lottoNumber = new LottoNumber(number);

        assertThat(lottoNumber.intValue()).isEqualTo(number);
    }

}
