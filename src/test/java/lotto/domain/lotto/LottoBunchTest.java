package lotto.domain.lotto;

import lotto.domain.lotto.number.LottoNumber;
import lotto.domain.lotto.number.LottoNumbers;
import lotto.domain.prize.LottoPrize;
import lotto.domain.prize.MatchResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoBunchTest {

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
        Lotto lotto = Lotto.of(LottoNumbers.of(lottoNumbers));

        //act
        LottoBunch lottoBunch = LottoBunch.of(Arrays.asList(lotto));

        //assert
        assertAll(
                () -> assertThat(lottoBunch.getAllLottoCount()).isEqualTo(1),
                () -> assertThat(lottoBunch.getLottos()).contains(lotto)
        );
    }

    @DisplayName("LottoNUmber 6개 보다작으면 IllegalArgumentException을 리턴한다")
    @Test
    public void should_throw_exception_empty_lotto_list() throws Exception {
        //arrange, act, assert
        assertThatIllegalArgumentException().isThrownBy(() -> LottoBunch.of(new ArrayList<>()));
    }

    @DisplayName("LottoNUmber 6개 보다작으면 IllegalArgumentException을 리턴한다")
    @Test
    public void should_throw_exception_null_lotto_list() throws Exception {
        //arrange, act, assert
        assertThatIllegalArgumentException().isThrownBy(() -> LottoBunch.of(null));
    }

    @DisplayName("WinningLottoNumber와 매치가 되면 Map<LottoPrize, Long>형태로 값을 반환한다 ")
    @Test
    public void shoud_return_prize_and_count_when_match_lotto() throws Exception {
        //arrange
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        );
        Lotto lotto = Lotto.of(LottoNumbers.of(lottoNumbers));
        List<LottoNumber> lottoNumbersFirst = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(14),
                LottoNumber.of(15),
                LottoNumber.of(16)
        );
        Lotto lottoFirst = Lotto.of(LottoNumbers.of(lottoNumbersFirst));
        LottoBunch lottoBunch = LottoBunch.of(Arrays.asList(lotto, lottoFirst));
        List<LottoNumber> winningLottoNumbers = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(14),
                LottoNumber.of(15),
                LottoNumber.of(16)
        );
        WinningLotto winningLotto = WinningLotto.of(LottoNumbers.of(winningLottoNumbers));
        Set<LottoPrize> expectedLottoPrize = new HashSet<>(Arrays.asList(LottoPrize.FOURTH, LottoPrize.FIRST));
        List<Long> expectedCount = Arrays.asList(1L, 1L);

        //act
        MatchResult matchResult = lottoBunch.match(winningLotto);

        //assert
        assertAll(
                () -> assertThat(matchResult.getMatchResult().keySet()).containsAll(expectedLottoPrize),
                () -> assertThat(matchResult.getMatchResult().values()).containsAll(expectedCount)
        );
    }

}