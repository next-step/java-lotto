package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStatisticsTest {

    private Lottos lottos;

    @BeforeEach
    void setUp() {
        lottos = new Lottos(List.of(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)),
            new Lotto(List.of(1, 2, 4, 9, 10, 40)),
            new Lotto(List.of(1, 2, 3, 12, 17, 30))
        ));
    }

    @DisplayName("당첨 번호와 3~6개 일치하는 로또의 개수 구하기")
    @Test
    void collectAccordanceCountTest() {
        LottoStatistics lottoStatistics = new LottoStatistics();
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));

        AccordanceCount result = lottoStatistics.collectAccordanceCount(lottos, winningNumbers);

        assertThat(result.getCountsByWinningAccordanceInSequence()).hasSize(4);
    }
}
