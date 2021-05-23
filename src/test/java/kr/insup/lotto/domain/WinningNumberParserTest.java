package kr.insup.lotto.domain;

import kr.insup.lotto.utils.WinningNumberParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumberParserTest {

    @DisplayName("당첨 번호 입력 받은 값 파싱 테스트")
    @Test
    void 당첨_번호_입력_받은_값_파싱() {

        //given
        String input = "1, 3, 12, 32, 31, 45";
        //when
        List<String> winningNumberList = WinningNumberParser.parseWinningNumberToLotto(input);
        //then
        assertThat(winningNumberList).containsExactlyElementsOf(Arrays.asList("1", "3", "12", "32", "31", "45"));

    }
}
