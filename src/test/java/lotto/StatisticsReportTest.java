package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoWallet;
import lotto.domain.Prize;
import lotto.domain.StatisticsReport;
import lotto.domain.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StatisticsReportTest {

    @DisplayName("지난주 로또와 3개가 매칭된 로또 티켓이 2개 만들어진다.")
    @Test
    void createTwoOfThirePrizeLotto() {

        Lotto lotto1 = LottoGenerator.generate(Set.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = LottoGenerator.generate(Set.of(6, 5, 4, 3, 2, 1));
        LottoWallet lottoWallet = LottoWallet.of(List.of(lotto1, lotto2), 2);

        Lotto lastWeakLotto = LottoGenerator.generate(Set.of(6, 5, 4, 13, 12, 11));
        WinningLotto winningLotto = WinningLotto.of(lastWeakLotto, LottoNumber.from(45));

        StatisticsReport statisticsReport = StatisticsReport.of(lottoWallet);
        statisticsReport.report(winningLotto);

        assertThat(Prize.FIRST.rank().score()).isEqualTo(0);
        assertThat(Prize.SECOND.rank().score()).isEqualTo(0);
        assertThat(Prize.THIRD.rank().score()).isEqualTo(0);
        assertThat(Prize.FOURTH.rank().score()).isEqualTo(2);
        assertThat(Prize.BONUS.rank().score()).isEqualTo(0);
        assertThat(Prize.NOT_RANK.rank().score()).isEqualTo(0);
    }

    @DisplayName("2,000원 로또를 구매하고 5,000원이 당첨 되면 손익률은 2.5입니다.")
    @Test
    void rate() {
        LottoWallet lottoWallet = getLottoWallet();
        StatisticsReport statisticsReport = StatisticsReport.of(lottoWallet);
        Lotto lastWeakLotto = LottoGenerator.generate(Set.of(6, 5, 4, 13, 12, 11));
        WinningLotto winningLotto = WinningLotto.of(lastWeakLotto, LottoNumber.from(45));
        statisticsReport.report(winningLotto);

        assertThat(statisticsReport.rate()).isEqualTo(BigDecimal.valueOf(2.5));
    }

    private static LottoWallet getLottoWallet() {
        Lotto lotto1 = LottoGenerator.generate(Set.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = LottoGenerator.generate(Set.of(41, 42, 43, 44, 45, 36));
        return LottoWallet.of(List.of(lotto1, lotto2), 2);
    }

}
