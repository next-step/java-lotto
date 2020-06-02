package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class LottoNumbersTest {

    @Test
    @DisplayName("로또 1~45 숫자 리스트의 크기를 검증한다.")
    void 로또_숫자_리스트_테스트() {
        assertThat(LottoNumbers.getDefaultLottoNumbers()).hasSize(LottoNumber.LOTTO_NUMBER_MAX);
    }

    @Test
    @DisplayName("로또 숫자 번호 리스트를 생성하는데 어떤 예외도 발생하지 않는다.")
    void 로또_숫자_리스트_생성_테스트() {
        assertThatCode(() -> LottoNumbers.of(1,2,3,4,5,6)).doesNotThrowAnyException();
    }
}
