package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @ParameterizedTest
    @DisplayName("로또 번호 생성 성공 테스트")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void 로또_번호_생성_성공_테스트(int number) {
        LottoNumber lottoNumber = new LottoNumber(number);
        assertThat(lottoNumber.getNumber()).isEqualTo(lottoNumber);
    }

    @ParameterizedTest
    @DisplayName("로또 번호 생성 실패 테스트")
    @ValueSource(ints = {-1, 0, 46, 100})
    void 로또_번호_생성_실패_테스트(int number) {
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(RuntimeException.class);
    }

}
