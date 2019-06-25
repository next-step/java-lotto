package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class AnalyzerTest {

    private Analyzer analyzer;
    private Lottos lottos;

    @BeforeEach
    void setUp() {
        Lotto lotto1 = new Lotto(Arrays.asList(1,3,5,6,9,11));
        Lotto lotto2 = new Lotto(Arrays.asList(1,3,5,9,11,15));

        lottos = new Lottos(Arrays.asList(lotto1, lotto2));

        List<Integer> winningNumbers = Arrays.asList(1,3,5,6,9);
        analyzer = new Analyzer(winningNumbers);
    }

    @RepeatedTest(value = 5)
    void analyze() {
        Report report = analyzer.analyze(lottos);
        Map<Prize, Integer> status = report.getPrizeStatus();

        assertThat(status.get(Prize.valueOf(5))).isEqualTo(1);
    }
}
