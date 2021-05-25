package autolotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinStatisticsTest {
    WinStatistics winStatistics = new WinStatistics();

    @Test
    void generateWinWords() {
        winStatistics.collectWin(3);
        winStatistics.collectWin(4);
        winStatistics.collectWin(4);
        winStatistics.collectWin(5);
        winStatistics.collectWin(5);
        winStatistics.collectWin(5);
        winStatistics.collectWin(6);
        winStatistics.collectWin(6);
        winStatistics.collectWin(6);
        winStatistics.collectWin(6);

        String winWords = winStatistics.generateWinWords();
        String[] splitWord = winWords.split("\n");
        for (int i = 0; i < splitWord.length - 1; i++) {
            assertThat(splitWord[i].contains(String.valueOf(i + 1))).isTrue();
        }
    }

    @Test
    void generateWinWordsRatioLoss() {
        winStatistics.collectWin(1);
        String winWords = winStatistics.generateWinWords();
        String[] splitWord = winWords.split("\n");
        assertThat(splitWord[splitWord.length - 1].contains(String.valueOf(0))).isTrue();
        assertThat(splitWord[splitWord.length - 1].contains("손해")).isTrue();
    }

    @Test
    void generateWinWordsRatioProfit() {
        winStatistics.collectWin(3);
        String winWords = winStatistics.generateWinWords();
        String[] splitWord = winWords.split("\n");
        assertThat(splitWord[splitWord.length - 1].contains(String.valueOf(5000/1000))).isTrue();
        assertThat(splitWord[splitWord.length - 1].contains("이득")).isTrue();
    }
}

