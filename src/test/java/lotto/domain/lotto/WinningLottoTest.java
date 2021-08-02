package lotto.domain.lotto;

import lotto.domain.lotto.number.LottoNumber;
import lotto.domain.lotto.number.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.fixture.LottoFixture.createOneToSixLottoNumberSequence;
import static lotto.fixture.LottoFixture.getWinningLottoNumber;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {
    @DisplayName("LottoNumbers와 BonusNumber가 있으면 WinningLotto를 만들수 있다")
    @Test
    public void should_make_object_with_lotto_numbers() throws Exception {
        //arrange
        List<LottoNumber> lottoNumberList = createOneToSixLottoNumberSequence();
        LottoNumbers lottoNumbers = LottoNumbers.of(lottoNumberList);
        LottoNumber bonusNumber = getWinningLottoNumber();

        //act
        WinningLotto winningLotto = WinningLotto.of(lottoNumbers, bonusNumber);

        //assert
        assertAll(
                () -> assertTrue(winningLotto.contains(LottoNumber.of(1))),
                () -> assertTrue(winningLotto.contains(LottoNumber.of(6)))
        );
    }

    @DisplayName("LottoNumbers가 null이면 IllegalStateException을 리턴한다")
    @Test
    public void should_throw_exception_lottonumbers_null() throws Exception {
        //arrange, act, assert
        assertThatIllegalStateException().isThrownBy(() -> WinningLotto.of(null, getWinningLottoNumber()));
    }

    @DisplayName("보너스 번호가 null이면 IllegalStateException을 리턴한다")
    @Test
    public void should_throw_exception_bonus_lottonumber_null() throws Exception {
        //arrange
        //arrange
        List<LottoNumber> lottoNumberList = createOneToSixLottoNumberSequence();
        LottoNumbers lottoNumbers = LottoNumbers.of(lottoNumberList);
        LottoNumber bonusNumber = null;

        //act, assert
        assertThatIllegalStateException().isThrownBy(() -> WinningLotto.of(lottoNumbers, bonusNumber));
    }

    @DisplayName("보너스 번호가 당첨 로또 번호와 중복되면 IllegalStateException을 리턴한다")
    @Test
    public void should_throw_exception_bonus_duplicate_winnig_lotto_numbers() throws Exception {
        //arrange
        //arrange
        List<LottoNumber> lottoNumberList = createOneToSixLottoNumberSequence();
        LottoNumbers lottoNumbers = LottoNumbers.of(lottoNumberList);
        LottoNumber bonusNumber = LottoNumber.of(1);

        //act, assert
        assertThatIllegalStateException().isThrownBy(() -> WinningLotto.of(lottoNumbers, bonusNumber));
    }

    @DisplayName("일치하는 로또 넘버가 있으면 true를 리턴한다")
    @Test
    public void should_return_true_contains_number() throws Exception {
        //arrange
        List<LottoNumber> lottoNumberList = createOneToSixLottoNumberSequence();
        LottoNumbers lottoNumbers = LottoNumbers.of(lottoNumberList);
        LottoNumber bonusNumber = getWinningLottoNumber();
        WinningLotto winningLotto = WinningLotto.of(lottoNumbers, bonusNumber);

        //act
        boolean isContain = winningLotto.contains(LottoNumber.of(1));

        //assert
        assertTrue(isContain);
    }

    @DisplayName("일치하는 로또 넘버가 없으면 false를 리턴한다")
    @Test
    public void should_return_false_contains_number() throws Exception {
        //arrange
        List<LottoNumber> lottoNumberList = createOneToSixLottoNumberSequence();
        LottoNumbers lottoNumbers = LottoNumbers.of(lottoNumberList);
        LottoNumber bonusNumber = getWinningLottoNumber();
        WinningLotto winningLotto = WinningLotto.of(lottoNumbers, bonusNumber);

        //act
        boolean isContain = winningLotto.contains(LottoNumber.of(33));

        //assert
        assertFalse(isContain);
    }

    @DisplayName("보너스번호와 일치하는 로또 넘버가 있으면 true를 리턴한다")
    @Test
    public void should_return_true_contains_bonus_number() throws Exception {
        //arrange
        List<LottoNumber> lottoNumberList = createOneToSixLottoNumberSequence();
        LottoNumbers lottoNumbers = LottoNumbers.of(lottoNumberList);
        LottoNumber bonusNumber = getWinningLottoNumber();
        WinningLotto winningLotto = WinningLotto.of(lottoNumbers, bonusNumber);

        //act
        boolean isContain = winningLotto.containsBonusNumber(getWinningLottoNumber());

        //assert
        assertTrue(isContain);
    }

    @DisplayName("보너스번호와 일치하지 않으면 false를 리턴한다")
    @Test
    public void should_return_false_contains_bonus_number() throws Exception {
        //arrange
        List<LottoNumber> lottoNumberList = createOneToSixLottoNumberSequence();
        LottoNumbers lottoNumbers = LottoNumbers.of(lottoNumberList);
        LottoNumber bonusNumber = getWinningLottoNumber();
        WinningLotto winningLotto = WinningLotto.of(lottoNumbers, bonusNumber);

        //act
        boolean isContain = winningLotto.containsBonusNumber(LottoNumber.of(33));

        //assert
        assertFalse(isContain);
    }
}