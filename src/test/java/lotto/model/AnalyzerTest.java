package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class AnalyzerTest {

    private Analyzer analyzer;
    private Lottos lottos;
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        Lotto lotto1 = new Lotto(Arrays.asList(1,3,5,6,9,11));
        Lotto lotto2 = new Lotto(Arrays.asList(1,3,5,9,11,15));

        lottos = new Lottos(Arrays.asList(lotto1, lotto2));

        List<Integer> winningNumbers = Arrays.asList(1,3,5,6,9);
        Lotto lottoWithWinningNumbers = LottoGenerator.generate(winningNumbers);

        int bonusNumber = 3;
        winningLotto = new WinningLotto(lottoWithWinningNumbers, bonusNumber);
        analyzer = new Analyzer(winningLotto);
    }

    @Test
    void analyze() {
        Report report = analyzer.analyze(lottos);
        Map<Prize, Integer> status = report.getPrizeStatus();

        assertThat(status.get(Prize.SECOND)).isEqualTo(1);
    }

    @Test
    void increasePrizeCount() {
        final Map<Prize, Integer> prizeStatus = new HashMap<>();

        List<Prize> prizes = lottos.matches(winningLotto);
        prizes.forEach(prize -> analyzer.increasePrizeCount(prize, prizeStatus));

        assertThat(prizeStatus.get(Prize.SECOND)).isEqualTo(1);
        assertThat(prizeStatus.size()).isEqualTo(2);
    }
}
