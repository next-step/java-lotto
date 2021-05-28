package kr.insup.lotto.domain;

import kr.insup.lotto.utils.LottoNumberParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberParserTest {

    @DisplayName("당첨 번호 입력 받은 값 파싱 테스트")
    @Test
    void 당첨_번호_입력_받은_값_파싱() {

        //given
        String input = "1, 3, 12, 32, 31, 45";

        //when
        List<Integer> winningNumberList = LottoNumberParser.parseLottoNumberToList(input);

        //then
        assertThat(winningNumberList).containsExactlyElementsOf(Arrays.asList(1, 3, 12, 32, 31, 45));
    }

    @DisplayName("당첨 번호 입력 받은 값 파싱(숫자가 아닌 값 입력)")
    @Test
    void 당첨_번호_입력_받은_값_파싱_숫자가_아닌_값_입력() {

        //given
        String input = "1, 3, 12, 32, 31, as";

        //when, then
        assertThatThrownBy(() -> LottoNumberParser.parseLottoNumberToList(input))
                .isInstanceOf(NumberFormatException.class);
    }
}
