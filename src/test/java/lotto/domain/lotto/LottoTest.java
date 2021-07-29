package lotto.domain.lotto;

import lotto.domain.lotto.number.LottoNumber;
import lotto.domain.prize.LottoPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTest {
    @DisplayName("LottoNUmber 6개 이면 Lotto 객체를 만든다")
    @Test
    public void should_make_object_with_count_6_lotto_number() throws Exception {
        //arrange
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        );

        //act
        Lotto lotto = Lotto.of(lottoNumbers);

        //assert
        assertThat(lotto.getLottoNumbers()).isEqualTo(lottoNumbers);
    }

    @DisplayName("LottoNumber 6개 보다작으면 IllegalArgumentException을 리턴한다")
    @Test
    public void should_throw_exception_under_count_6_lotto_number() throws Exception {
        //arrange
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5)
        );

        //act, assert
        assertThatIllegalArgumentException().isThrownBy(() -> Lotto.of(lottoNumbers));
    }

    @DisplayName("LottoNUmber 6개 보다 크면 IllegalArgumentException을 리턴한다")
    @Test
    public void should_throw_exception_over_count_6_lotto_number() throws Exception {
        //arrange
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6),
                LottoNumber.of(7)
        );

        //act, assert
        assertThatIllegalArgumentException().isThrownBy(() -> Lotto.of(lottoNumbers));
    }

    @DisplayName("WinningLottoNumber와 매치가 되면 LottoPrize 값을 반환한다 ")
    @Test
    public void shoud_return_prize_when_match_lotto() throws Exception {
        //arrange
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        );
        Lotto lotto = Lotto.of(lottoNumbers);
        List<LottoNumber> winningLottoNumbers = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(14),
                LottoNumber.of(15),
                LottoNumber.of(16)
        );
        WinningLotto winningLotto = WinningLotto.of(winningLottoNumbers);

        //act
        LottoPrize lottoPrize = lotto.match(winningLotto);

        //act, assert
        assertAll(
                () -> assertThat(lottoPrize.getMatchCount()).isEqualTo(3),
                () -> assertThat(lottoPrize).isEqualTo(LottoPrize.FOURTH)
        );
    }
}