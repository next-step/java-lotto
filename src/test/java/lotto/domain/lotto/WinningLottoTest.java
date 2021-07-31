package lotto.domain.lotto;

import lotto.domain.lotto.number.LottoNumber;
import lotto.domain.lotto.number.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.fixture.LottoFixture.createOneToSixLottoNumberSequence;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WinningLottoTest {
    @DisplayName("LottoNumbers가 있으면 WinningLotto를 만들수 있다")
    @Test
    public void should_make_object_with_lotto_numbers() throws Exception {
        //arrange
        List<LottoNumber> lottoNumberList = createOneToSixLottoNumberSequence();
        LottoNumbers lottoNumbers = LottoNumbers.of(lottoNumberList);

        //act
        WinningLotto winningLotto = WinningLotto.of(lottoNumbers);

        //assert
        assertAll(
                () -> assertTrue(winningLotto.contains(LottoNumber.of(1))),
                () -> assertTrue(winningLotto.contains(LottoNumber.of(6)))
        );
    }

    @DisplayName("LottoNumbers가 null이면 IllegalArgumentException을 리턴한다")
    @Test
    public void should_throw_exception_lottonumber_null() throws Exception {
        //arrange, act, assert
        assertThatIllegalArgumentException().isThrownBy(() -> WinningLotto.of(null));
    }
}