package lotto.service;

import lotto.model.Lotto;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PrizeStatisticsServiceTest {
    private PrizeStatisticsService prizeStatisticsService;

    @Before
    public void setup() {
        List<Lotto> lottos = Arrays.asList(
            new Lotto(Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toSet())),
            new Lotto(Stream.of(34, 35, 5, 38, 13, 30).collect(Collectors.toSet())),
            new Lotto(Stream.of(3, 36, 37, 41, 27, 13).collect(Collectors.toSet()))
        );
        Set<Integer> prizeNumbers = Stream.of(1,2, 3, 34, 35, 41).collect(Collectors.toSet());

        prizeStatisticsService = new PrizeStatisticsService();
        prizeStatisticsService.calculate(lottos, prizeNumbers);
    }

    @Test
    public void 당첨번호를_기준으로_구매한_로또_번호_일치_개수() {
        assertThat(0).isEqualTo(prizeStatisticsService.getMatchCount(0));
        assertThat(1).isEqualTo(prizeStatisticsService.getMatchCount(3));
    }

    @Test
    public void 수익률() {
        assertThat(0.6).isEqualTo(prizeStatisticsService.getReturnsOfInvestment(3000));
    }
}
