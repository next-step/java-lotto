package lotto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoWallet;
import lotto.domain.Prize;
import lotto.domain.StatisticsReport;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StatisticsReportTest {

    @DisplayName("지난주 로또와 3개가 매칭된 로또 티켓이 2개 만들어진다.")
    @Test
    void createTwoOfThirePrizeLotto() {

        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6).stream().map(LottoNumber::new).collect(Collectors.toList()));
        Lotto lotto2 = new Lotto(List.of(6, 5, 4, 3, 2, 1).stream().map(LottoNumber::new).collect(Collectors.toList()));
        LottoWallet lottoWallet = LottoWallet.of(List.of(lotto1, lotto2), 2);

        Prize third = Prize.THIRD;

        StatisticsReport statisticsReport = new StatisticsReport(lottoWallet, Map.of(third, 2));
        Assertions.assertThat(statisticsReport.countByPrize(third)).isEqualTo(2);
    }

}
