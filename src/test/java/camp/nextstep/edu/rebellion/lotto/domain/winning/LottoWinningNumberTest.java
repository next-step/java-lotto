package camp.nextstep.edu.rebellion.lotto.domain.winning;

import camp.nextstep.edu.rebellion.lotto.domain.LottoAward;
import camp.nextstep.edu.rebellion.lotto.domain.ticket.Lotto;
import camp.nextstep.edu.rebellion.lotto.util.StringUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoWinningNumberTest {
    @DisplayName("입력된 문자열로 부터 당첨 번호가 잘 생성 되는지 확인")
    @Test
    public void lottoWinningNumberTest() {
        // given
        String input = "1,2,3,4,5,6";

        // when & then
        assertDoesNotThrow(() -> new LottoWinningNumber(input));
    }

    @DisplayName("당첨 번호가 1과 45사이를 벗어날 경우 예외")
    @Test
    public void lottoWinningNumberThrownTest() {
        // given
        String input = "46,1,2,3,4,5";

        // when & then
        assertThatThrownBy(() -> new LottoWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨번호가 잘못되었습니다 46");
    }

    @DisplayName("입력된 로또 번호와 당첨 되었을 경우 당첨 결과를 잘 가져오는지 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6:6",
            "1,2,3,4,5,16:5",
            "1,2,3,4,15,16:4",
            "1,2,3,14,15,16:3",
            "1,2,13,14,15,16:0"
    }, delimiter = ':')
    public void matchResultTest(String numbers, int matchCount) {
        // given
        String winningNumberInput = "1,2,3,4,5,6";
        Lotto lotto = new Lotto(
                StringUtil.convertList(numbers)
                        .stream()
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
        );

        LottoWinningNumber winningNumber =
                new LottoWinningNumber(winningNumberInput);

        // when
        LottoAward result = winningNumber.getMatchResult(lotto);

        // then
        assertThat(result).isEqualTo(LottoAward.of(matchCount));
    }
}
