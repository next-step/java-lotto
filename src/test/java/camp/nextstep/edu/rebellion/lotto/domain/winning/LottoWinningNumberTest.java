package camp.nextstep.edu.rebellion.lotto.domain.winning;

import camp.nextstep.edu.rebellion.lotto.domain.LottoAward;
import camp.nextstep.edu.rebellion.lotto.domain.ticket.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinningNumberTest {

    @DisplayName("당첨번호와 비교했을 때 당첨 결과가 잘 나오는지 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6:6",
            "1,2,3,4,5,16:5",
            "1,2,3,4,15,16:4",
            "1,2,3,14,15,16:3",
            "1,2,13,14,15,16:0"
    }, delimiter = ':')
    public void getAwardResultTest(String input, int award) {
        // given
        // bonus 는 45로 fix 합니다
        // 2등 당첨 확인은 다른 테스트를 통해 진행합니다
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(new Lotto("1,2,3,4,5,6"), 45);
        Lotto lotto = new Lotto(input);

        // when & then
        assertThat(lottoWinningNumber.getAwardResult(lotto))
                .isEqualTo(LottoAward.valueOf(award, false));
    }

    @DisplayName("2등 담청(보너스) 확인")
    @Test
    public void getSecondAwardTest() {
        // given
        LottoWinningNumber winningNumber = new LottoWinningNumber(new Lotto("1,2,3,4,5,45"), 6);
        Lotto lotto = new Lotto("1,2,3,4,5,6");

        // when & then
        assertThat(winningNumber.getAwardResult(lotto)).isEqualTo(LottoAward.SECOND);
    }
}
