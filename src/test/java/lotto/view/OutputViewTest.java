package lotto.view;

import lotto.domain.Rank;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    @ParameterizedTest(name = "2등 당첨 통계는 '보너스 볼 일치' 라는 문구를 포함한다.")
    @CsvSource(value = {"SECOND, true", "THIRD, false", "FIRST, false"})
    public void secondRankMatchResultTest(Rank rank, boolean containBonusBallMatchMessage) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        OutputView outputView = OutputView.of(new PrintStream(out));
        outputView.printMatchCount(rank, 1);
        assertThat(out.toString().contains("보너스 볼 일치"))
                .isEqualTo(containBonusBallMatchMessage);
    }

}