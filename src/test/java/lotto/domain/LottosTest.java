package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setup() {
        lottoGenerator = new TesterLottoGenerator();
    }

    @DisplayName("Lottos 생성 테스트")
    @Test
    void of() {
        List<Lotto> lottos = Arrays.asList(Lotto.of(lottoGenerator), Lotto.of(lottoGenerator));

        assertThat(new Lottos(lottos))
                .isEqualToComparingFieldByField(new Lottos(lottos));
    }

    @DisplayName("로또 리스트 당첨금액과 당첨금액율 계산 테스트")
    @ParameterizedTest(name = "[{index}] {0}의 당첨금은 {1}원 ({2})")
    @CsvSource(value = {
            "           FIRST,SECOND | 2001500000 | 1000750",
            "     SECOND,FOURTH,NONE |    1505000 | 501.66",
            "    FOURTH,FOURTH,FIFTH |      10000 | 3.33",
            " FIFTH,FIFTH,SIXTH,NONE |          0 | 0 ",
            " FOURTH,SIXTH,SIXTH,SIXTH,SIXTH,SIXTH,NONE,NONE | 5000 | 0.62",
    }, delimiter = '|')
    void calculateProfit(String lottoRank, long expectedProfit, String expectedProfitRateString) {
        BigDecimal expectedProfitRate = new BigDecimal(expectedProfitRateString);
        Lottos lottos = build(lottoRank);

        lottos.setStatistics();

        assertThat(lottos.calculateProfit()).isEqualByComparingTo(expectedProfit);
        assertThat(lottos.calculateProfitRate()).isEqualByComparingTo(expectedProfitRate);
    }

    private Lottos build(String lottoRank) {
        List<Lotto> lottoList = Arrays.stream(lottoRank.split(","))
                .map(LottoRank::valueOf)
                .map(this::build)
                .collect(Collectors.toList());
        return new Lottos(lottoList);
    }

    private Lotto build(LottoRank lottoRank) {
        Lotto lotto = Lotto.of(lottoGenerator);
        lotto.scratchLotto(lottoRank);
        return lotto;
    }
}
