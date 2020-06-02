package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    private LottoMachine lottoMachine = new LottoMachine();

    @DisplayName("금액만큼의 로또를 발급한다")
    @ParameterizedTest
    @CsvSource({"3000, 3", "10000, 10"})
    void issue_Then_issuedLottoPriceEqualsToPaidPrice(int paidMoney, int expected) {
        LottoIssueRequest request = new LottoIssueRequest(paidMoney, Collections.emptyList());

        Lottos lottos = lottoMachine.issue(request);

        assertThat(lottos.size()).isEqualTo(expected);
    }
}
