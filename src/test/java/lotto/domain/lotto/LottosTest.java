package lotto.domain.lotto;

import lotto.domain.lotto.number.LottoNumber;
import lotto.domain.lotto.number.LottoNumbers;
import lotto.domain.prize.LottoPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.*;

import static lotto.fixture.LottoFixture.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottosTest {
    @DisplayName("LottoNumber 6개 이면 Lotto 객체를 만든다")
    @Test
    public void should_make_object_with_count_6_lotto_number() throws Exception {
        //arrange
        List<LottoNumber> lottoNumbers = createOneToSixLottoNumberSequence();

        Lotto lotto = Lotto.of(LottoNumbers.of(lottoNumbers));

        //act
        Lottos lottos = Lottos.of(Arrays.asList(lotto));

        //assert
        assertThat(lottos.size()).isEqualTo(1);
    }

    @DisplayName("lottos가 null이면 IllegalStateException을 리턴한다")
    @Test
    public void should_throw_exception_under_count_6_lotto_number() throws Exception {
        //arrange, act, assert
        assertThatIllegalStateException().isThrownBy(() -> Lottos.of(null));
    }


    @DisplayName("WinningLottoNumber와 매치가 되면 Map<LottoPrize, Long>형태로 값을 반환한다 ")
    @Test
    public void shoud_return_prize_and_count_when_match_lotto() throws Exception {
        //arrange
        Lottos lottos = getLottos();
        WinningLotto winningLotto = getWinningLotto();
        Set<LottoPrize> expectedLottoPrize = new HashSet<>(Arrays.asList(LottoPrize.FOURTH, LottoPrize.FIRST));
        List<Long> expectedCount = Arrays.asList(1L, 1L);

        //act
        Map<LottoPrize, Long> matchMap = lottos.calculateMatch(winningLotto);

        //assert
        assertAll(
                () -> assertThat(matchMap.keySet()).containsAll(expectedLottoPrize),
                () -> assertThat(matchMap.values()).containsAll(expectedCount)
        );
    }

}