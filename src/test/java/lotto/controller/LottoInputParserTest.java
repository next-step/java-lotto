package lotto.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.data.LottoNumbers;
import lotto.input.InputReader;

class LottoInputParserTest {
    @DisplayName("bonus_exceeded_value")
    @Test
    void validate_bonus_min() {
        LottoNumbers winningNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        InputReader inputReader1 = new TestInputReader("0", "1, 2, 3, 4, 5, 6");
        InputReader inputReader2 = new TestInputReader("46", "1, 2, 3, 4, 5, 6");

        assertThatThrownBy(() -> LottoInputParser.getBonus(inputReader1, winningNumbers)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoInputParser.getBonus(inputReader2, winningNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("winning_number_counts_range")
    @Test
    void validate_winning_number_count() {
        InputReader inputReader1 = new TestInputReader("45", "1, 2, 3, 4, 5, 6, 7");
        InputReader inputReader2 = new TestInputReader("45", "1, 2, 3, 4, 5");

        assertThatThrownBy(() -> LottoInputParser.getWinningInput(inputReader1)).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> LottoInputParser.getWinningInput(inputReader2)).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("bonus_number_duplicate")
    @Test
    void validate_duplicate_number() {
        LottoNumbers winningNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        InputReader inputReader = new TestInputReader("6", "1, 2, 3, 4, 5, 6");

        assertThatThrownBy(() -> LottoInputParser.getBonus(inputReader, winningNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    private static class TestInputReader implements InputReader {
        private final String readIntValue;
        private final String readLineValue;

        private TestInputReader(String readIntValue, String readLineValue) {
            this.readIntValue = readIntValue;
            this.readLineValue = readLineValue;
        }

        @Override
        public int readInt(String comment) {
            return Integer.parseInt(readIntValue);
        }

        @Override
        public String readLine(String comment) {
            return readLineValue;
        }
    }
}
