package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningStatisticsTest {


    private static final int LOTTO_COUNT = 10;
    private static final int WINNING_LOWER_NUMBER = 1;
    private static final int WINNING_UPPER_NUMBER = 6;

    private WinningStatistics winningStatistics;
    private Lottos lottos;
    private WinningNumbers winningNumbers;
    private List<LottoNumber> winningList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        LottoFactory.setLottoStrategy(new AutoLottoStrategy());
        LottoFactory.defaultLottoNumbers();
        lottos = LottoFactory.lottos(LOTTO_COUNT);

        for (int i = WINNING_LOWER_NUMBER; i < WINNING_UPPER_NUMBER; i++) {
            winningList.add(new LottoNumber(i));
        }
        winningNumbers = LottoFactory.winning(winningList);
    }

    @Test
    void createTest() {
        winningStatistics = new WinningStatistics(lottos, winningNumbers);
        assertThat(winningStatistics).isEqualTo(new WinningStatistics(lottos, winningNumbers));
    }
}
