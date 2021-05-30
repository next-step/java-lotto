package lotto;

import lotto.domain.LastWonLottoNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LastWonLottoNumberTest {

    @Test
    public void LastWonLottoNumber_당첨번호객체생성검증() {

        LastWonLottoNumber lastWonLottoNumber = new LastWonLottoNumber("1,22,33,4,5,6,", "7");

        assertThat(lastWonLottoNumber.getLastWonLottoNumbers().contains(1)).isTrue();
        assertThat(lastWonLottoNumber.getLastWonLottoNumbers().contains(22)).isTrue();
        assertThat(lastWonLottoNumber.getLastWonLottoNumbers().contains(33)).isTrue();
        assertThat(lastWonLottoNumber.getLastWonLottoNumbers().contains(4)).isTrue();
        assertThat(lastWonLottoNumber.getLastWonLottoNumbers().contains(5)).isTrue();
        assertThat(lastWonLottoNumber.getLastWonLottoNumbers().contains(6)).isTrue();
        assertThat(lastWonLottoNumber.getLastWonLottoNumbers().contains(7)).isFalse();
    }

    @Test
    public void LastWonValidateNumber_로또번호검증_문자입력() {
        assertThatThrownBy(() -> new LastWonLottoNumber("1,a,3,4,5,6", "7"))
                .isInstanceOf(RuntimeException.class).hasMessage("숫자만 입력 가능합니다.");
    }

    @Test
    public void LastWonValidateNumber_로또번호검증_45초과입력() {
        assertThatThrownBy(() -> new LastWonLottoNumber("1,2,3,4,5,56", "7"))
                .isInstanceOf(RuntimeException.class).hasMessage("1부터 45까지 숫자만 입력 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    public void lastWonLottoNumbers_지난당첨번호문자열파싱검증(int number) {
        LastWonLottoNumber lastWonLottoNumber = new LastWonLottoNumber("1,2,3,4,5,6", "7");
        assertThat(lastWonLottoNumber.containsMain(number)).isTrue();
    }

}
