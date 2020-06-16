package lotto.domain;

import lotto.StringParser;
import org.junit.jupiter.api.BeforeEach;
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

    List<Lotto> lottos;
    WinningNumbers winningNumbers;

    @BeforeEach
    void setUp(){
        Lotto lotto1 = Lotto.of(StringParser.getParseNumbers("1, 2, 3, 4, 5, 6"));
        Lotto lotto2 = Lotto.of(StringParser.getParseNumbers("1, 2, 3, 4, 5, 7"));

        Lotto winningLotto = Lotto.of(StringParser.getParseNumbers("1, 2, 3, 7, 9, 10"));
        LottoNumber bonusNumber = LottoNumber.of(11);
        winningNumbers = WinningNumbers.of(winningLotto, bonusNumber);

        lottos = new ArrayList<>(Arrays.asList(lotto1, lotto2));
    }

    @DisplayName("당첨번호가 6자가 아닐 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7", "1,2,3,4,5"})
    void whenWinningNumbersHasNot6NumbersThenException(String input){

        // then
        assertThatIllegalArgumentException().isThrownBy(
                () -> {
                    Lotto winningNumbers = Lotto.of(StringParser.getParseNumbers(input));
                    LottoNumber bonusNumber = LottoNumber.of(9);
                    LottoResult.of(WinningNumbers.of(winningNumbers, bonusNumber), null);
                }
        );
    }

    @DisplayName("LottoResult 생성시 로또 목록과 당첨번호를 넘기면 Match 생성")
    @Test
    void makeMatchesTest(){

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
        Lotto lotto3 = Lotto.of(StringParser.getParseNumbers("1, 2, 3, 4, 6, 7"));
        lottos.add(lotto3);

        // when
        LottoResult lottoResult = LottoResult.of(winningNumbers, lottos);
        Map<Rank, Long> matchResult = lottoResult.getMatches();

        // then
        assertThat(matchResult.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(matchResult.get(Rank.FOURTH)).isEqualTo(2);
    }

    @DisplayName("LottoResult 생성 후 구매금액 입력 시 수익률 반환")
    @Test
    void whenInputPurchasePriceReturnRate(){

        // given
        Money money = Money.of(3000);

        // when
        LottoResult lottoResult = LottoResult.of(winningNumbers, lottos);
        double returnRate = lottoResult.getReturnRate(money);

        assertThat(returnRate).isEqualTo(18.33);
    }
}