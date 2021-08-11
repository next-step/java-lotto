package lotto.common;

import lotto.common.WinningNumberParser;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumberParserTest {

    @Test
    public void 문자열을_입력받았을_때_파싱을_통해_List로_변환할_수_있다(){
        //given
        WinningNumberParser parser = new WinningNumberParser();
        //when
        List<Integer> winningNumbers = parser.parseToWinningNumbers("1, 2, 3, 4, 5, 6");
        //then
        assertThat(winningNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
