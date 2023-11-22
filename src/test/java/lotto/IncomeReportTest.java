package lotto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IncomeReportTest {

    @DisplayName("2,000원 로또를 구매하고 5,000원이 당첨 되면 손익률은 2.5입니다.")
    @Test
    void rate() {
        LottoWallet lottoWallet = getLottoWallet();
        StatisticsReport statisticsReport = new StatisticsReport(lottoWallet,
            Map.of(Prize.FOURTH, 1));
        Assertions.assertThat(statisticsReport.rate()).isEqualTo(BigDecimal.valueOf(2.5));
    }

    private static LottoWallet getLottoWallet() {
        Lotto lotto1 = new Lotto(Stream.of(1, 2, 3, 4, 5, 6)
            .map(LottoNumber::new)
            .collect(Collectors.toList()));
        Lotto lotto2 = new Lotto(Stream.of(1, 2, 3, 4, 5, 6)
            .map(LottoNumber::new)
            .collect(Collectors.toList()));
        return LottoWallet.of(List.of(lotto1, lotto2), 2);
    }
}
