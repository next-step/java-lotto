package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ReportTest {

    private Report report;

    @BeforeEach
    void setUp() {
        report = new Report(getPrizeStatus(), getLottos());
    }

    private Map<Prize, Integer> getPrizeStatus() {
        Map<Prize, Integer> prizeStatus = new HashMap<>();
        prizeStatus.put(Prize.FIRST, 1);
        prizeStatus.put(Prize.FOURTH, 1);
        return prizeStatus;
    }

    private Lottos getLottos() {
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 10, 11));
        return new Lottos(Arrays.asList(lotto1, lotto2));
    }

    @Test
    void rateOfReturn() {
        double total = Prize.FIRST.getPrizeMoney() + Prize.FOURTH.getPrizeMoney();
        double buyingMoney = Lotto.PRICE * 2;
        assertThat(report.rateOfReturn()).isEqualTo(total / buyingMoney);
    }

    @Test
    void totalProfits() {
        assertThat(report.totalProfits()).isEqualTo(Prize.FIRST.getPrizeMoney() + Prize.FOURTH.getPrizeMoney());
    }

    @Test
    void buyingMoney() {
        assertThat(report.buyingMoney()).isEqualTo(Lotto.PRICE * 2);
    }
}
