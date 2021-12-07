package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinningRulesTest {

    @DisplayName("로또 당첨 숫자와 일치하는 숫자가 3개 이상이면 당첨이다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6})
    void winLotto(int numberOfMatches) {
        LottoWinningRules lottoWInningRules = new LottoWinningRules();
        assertThat(lottoWInningRules.isWinLotto(numberOfMatches)).isEqualTo(true);
    }

    @DisplayName("로또 당첨 숫자와 일치하는 숫자가 3개 미만이면 낙첨이다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void loseLotto(int numberOfMatches) {
        LottoWinningRules lottoWInningRules = new LottoWinningRules();
        assertThat(lottoWInningRules.isWinLotto(numberOfMatches)).isEqualTo(false);
    }

    @DisplayName("일치하는 숫자 개수에 따라 당첨금액을 알려준다.")
    @ParameterizedTest
    @CsvSource(value = {"3:5000", "4:50000", "5:1500000", "6:2000000000"}, delimiter = ':')
    void getPrizeOf(int numberOfMatches, int prize){
        LottoWinningRules lottoWInningRules = new LottoWinningRules();
        int returnedPrize = lottoWInningRules.getPrizeOf(numberOfMatches);
        assertThat(returnedPrize).isEqualTo(prize);
    }

}