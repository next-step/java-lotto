package step2.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {
    @DisplayName("로또 번호가 아닌 경우 예외 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 100})
    public void out_Of_LottoRange_Test(int number) {

        assertThatThrownBy(() -> {
            new LottoNumber(number);
        }).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("로또 번호 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 42, 43, 44, 45})
    public void create_Lotto_Numbers_Test(int number) {
        LottoNumber lottoNumber = new LottoNumber(number);
        assertThat(lottoNumber.getLottoNumber()).isEqualTo(number);
    }
}