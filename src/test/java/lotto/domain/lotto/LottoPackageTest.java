package lotto.domain.lotto;

import lotto.domain.lotto.number.LottoNumber;
import lotto.domain.lotto.number.LottoNumbers;
import lotto.domain.money.Money;
import lotto.domain.prize.LottoPrize;
import lotto.domain.prize.MatchResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static lotto.fixture.LottoFixture.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoPackageTest {

    @DisplayName("LottoNUmber 6개 이면 Lotto 객체를 만든다")
    @Test
    public void should_make_object_with_count_6_lotto_number() throws Exception {
        //arrange
        List<LottoNumber> lottoNumbers = createOneToSixLottoNumberSequence();
        Lotto lotto = Lotto.of(LottoNumbers.of(lottoNumbers));
        Lottos lottos = Lottos.of(Arrays.asList(lotto));
        Money money = Money.of(1000);

        //act
        LottoPackage lottoPackage = LottoPackage.of(lottos, money);

        //assert
        assertAll(
                () -> assertThat(lottoPackage.getAllLottoCount()).isEqualTo(1),
                () -> assertThat(lottoPackage.getLottos()).contains(lotto)
        );
    }

    @DisplayName("Money가 null이면 exception을 반환한다")
    @Test
    public void should_throw_exception_money_null() throws Exception {
        //arrange
        List<LottoNumber> lottoNumbers = createOneToSixLottoNumberSequence();
        Lotto lotto = Lotto.of(LottoNumbers.of(lottoNumbers));
        Lottos lottos = Lottos.of(Arrays.asList(lotto));
        Money money = null;

        //act, assert
        assertThatIllegalArgumentException().isThrownBy(()
                -> LottoPackage.of(lottos, money));
    }

    @DisplayName("LottoNUmber 6개 보다작으면 IllegalArgumentException을 리턴한다")
    @Test
    public void should_throw_exception_empty_lotto_list() throws Exception {
        //arrange, act, assert
        assertThatIllegalArgumentException().isThrownBy(()
                -> LottoPackage.of(Lottos.of(new ArrayList<>()), Money.of(1000)));
    }

    @DisplayName("LottoNUmber 6개 보다작으면 IllegalArgumentException을 리턴한다")
    @Test
    public void should_throw_exception_null_lotto_list() throws Exception {
        //arrange, act, assert
        assertThatIllegalArgumentException().isThrownBy(()
                -> LottoPackage.of(null, Money.of(1000)));
    }


    @DisplayName("WinningLottoNumber와 매치가 되면 MatchResult를 반환한다 ")
    @Test
    public void shoud_return_match_result() throws Exception {
        //arrange
        Lottos lottos = getLottos();
        LottoPackage lottoPackage = LottoPackage.of(lottos, Money.of(2000));
        WinningLotto winningLotto = getWinningLotto();
        Set<LottoPrize> expectedLottoPrize = new HashSet<>(Arrays.asList(LottoPrize.FOURTH, LottoPrize.FIRST));
        List<Long> expectedCount = Arrays.asList(1L, 1L);

        //act
        MatchResult matchResult = lottoPackage.match(winningLotto);

        //assert
        assertAll(
                () -> assertThat(matchResult.getMatchResult().keySet()).containsAll(expectedLottoPrize),
                () -> assertThat(matchResult.getMatchResult().values()).containsAll(expectedCount)
        );
    }

}