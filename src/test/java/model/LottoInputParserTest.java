package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.LottoInputParser;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoInputParserTest {
    private static final int UPPER_BOUND = 10;
    private static final int LOWER_BOUND = 0;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private LottoInputParser parser = new LottoInputParser(UPPER_BOUND, LOWER_BOUND, LOTTO_NUMBER_COUNT);


    @Test
    @DisplayName("생성 가능 번호 셋 확인")
    public void testGenerateNumberSet() {
        // when
        List<Integer> set = parser.generateRangeSet();

        // then
        assertThat(set.get(0)).isEqualTo(LOWER_BOUND);
        assertThat(set.get(set.size()-1)).isEqualTo(UPPER_BOUND);
    }

    @Test
    @DisplayName("정상 당첨 번호 입력 확인")
    public void testWinningNumberSetPares() {
        // given
        String winningNumbersString = "1, 2, 3, 4, 5, 6";

        // when
        List<Integer> winningNumbers = parser.parse(winningNumbersString);

        // then
        assertThat(winningNumbers).hasSize(LOTTO_NUMBER_COUNT);
    }

    @Test
    @DisplayName("보너스 번호 중복 케이스")
    public void testBonusNumberExistingInWinningSet() {
        // given
        String winningNumbersString = "1, 2, 3, 4, 5, 6";
        int bonusNumber = 1;

        // when
        List<Integer> winningNumbers = parser.parse(winningNumbersString);

        // then
        assertThatThrownBy(() -> parser.validateBonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호 out of range 케이스")
    public void testBonusNumberOutOfRange() {
        // given
        String winningNumbersString = "1, 2, 3, 4, 5, 6";
        int bonusNumber = 99;

        // when
        List<Integer> winningNumbers = parser.parse(winningNumbersString);

        // then
        assertThatThrownBy(() -> parser.validateBonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
