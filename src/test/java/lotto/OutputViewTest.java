package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Map;
import lotto.WinningNumbers.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OutputViewTest {

    OutputStream outputStream;

    @BeforeEach
    void 초기화() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void 당첨통계() {
        Map<Rank, Integer> map = Map.of(
            Rank.FIRST_GRADE, 0,
            Rank.SECOND_GRADE, 1,
            Rank.THIRD_GRADE, 1,
            Rank.FOURTH_GRADE, 0
        );
        OutputView.printRanking(map, 14000);
        assertAll(
            () -> assertThat(outputStream.toString()).containsPattern("당첨 통계"),
            () -> assertThat(outputStream.toString()).containsPattern("--------"),
            () -> assertThat(outputStream.toString()).containsPattern(
                "3개 일치 \\(" + 5_000 + "원\\)- ([\\d]+)개"),
            () -> assertThat(outputStream.toString()).containsPattern(
                "4개 일치 \\(" + 50_000 + "원\\)- ([\\d]+)개"),
            () -> assertThat(outputStream.toString()).containsPattern(
                "5개 일치 \\(" + 1_500_000 + "원\\)- ([\\d]+)개"),
            () -> assertThat(outputStream.toString()).containsPattern(
                "6개 일치 \\(" + 2_000_000_000 + "원\\)- ([\\d]+)개"),
            () -> assertThat(outputStream.toString()).containsPattern("총 수익률은 [\\d]+.[\\d]+입니다.")
        );

    }

}
