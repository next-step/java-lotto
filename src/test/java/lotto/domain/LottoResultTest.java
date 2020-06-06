package lotto.domain;

import lotto.StringParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoResultTest {

    @DisplayName("당첨번호가 6자가 아닐 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7", "1,2,3,4,5"})
    void whenWinningNumbersHasNot6NumbersThenException(String input){
        // given
        List<Integer> winningNumbers = StringParser.getParseNumbers(input);

        // then
        assertThatIllegalArgumentException().isThrownBy(
                () -> LottoResult.of(winningNumbers, null)
        );
    }

    @DisplayName("LottoResult 생성시 로또 목록과 당첨번호를 넘기면 Match 생성")
    @Test
    void makeMatchesTest(){
        // given
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 6, 7));

        List<Lotto> lottos = new ArrayList<>(Arrays.asList(lotto1, lotto2));
        List<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 7, 9, 10));

        // when
        LottoResult lottoResult = LottoResult.of(winningNumbers, lottos);

        System.out.println(lottoResult.getMatches());

        // then
        assertThat(lottoResult.getMatches()).hasSize(2);
    }

    @DisplayName("LottoResult 생성시 통계 결과 반환")
    @Test
    void whenCreateLottoResultThenReturnStatistics(){
        // given
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 6, 7));
        Lotto lotto3 = new Lotto(Arrays.asList(1, 2, 3, 4, 6, 7));

        List<Lotto> lottos = new ArrayList<>(Arrays.asList(lotto1, lotto2, lotto3));
        List<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 7, 9, 10));

        // when
        LottoResult lottoResult = LottoResult.of(winningNumbers, lottos);
        Map<Match, Integer> matchResult = lottoResult.getMatchResult();

        // then
        assertThat(matchResult.get(Match.THREE)).isEqualTo(1);
        assertThat(matchResult.get(Match.FOUR)).isEqualTo(2);
    }

    @DisplayName("LottoResult 생성 후 구매금액 입력 시 수익률 반환")
    @Test
    void whenInputPurchasePriceReturnRate(){
        // given
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 6, 7));

        List<Lotto> lottos = new ArrayList<>(Arrays.asList(lotto1, lotto2));
        List<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 7, 9, 10));

        // when
        LottoResult lottoResult = LottoResult.of(winningNumbers, lottos);
        double returnRate = lottoResult.getReturnRate(3000);

        assertThat(returnRate).isEqualTo(18.33);
    }
}