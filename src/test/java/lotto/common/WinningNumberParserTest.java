package lotto.common;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumberParserTest {

    @Test
    public void 문자열을_입력받았을_때_파싱을_통해_List로_변환할_수_있다() {
        //given
        WinningNumberParser parser = new WinningNumberParser();
        //when
        List<LottoNumber> winningNumbers = parser.parseToWinningNumbers("1, 2, 3, 4, 5, 6");
        //then
        assertThat(winningNumbers).containsExactly(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4), new LottoNumber(5),
                new LottoNumber(6));
    }
}
