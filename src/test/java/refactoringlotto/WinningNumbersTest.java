package refactoringlotto;

import org.junit.jupiter.api.Test;
import refactoringlotto.domain.LottoWinningCounts;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumbersTest {

    @Test
    public void 당첨번호일치개수_테스트() {
        List<LottoNumber> winningNumberList = List;
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningNumberList);
        //asserThat(lottoWinningNumbers.lottoRank(lottoNumberList));
        //TODO
    }
}
