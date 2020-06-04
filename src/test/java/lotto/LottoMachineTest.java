package lotto;

import lotto.application.LottoIssueRequest;
import lotto.application.LottoIssueResponse;
import lotto.application.LottoMachine;
import lotto.domain.LottoMoney;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    private LottoMachine lottoMachine = new LottoMachine();

    @DisplayName("금액만큼의 로또를 발급한다")
    @ParameterizedTest
    @CsvSource({"3000, 3", "10000, 10"})
    void issue_Then_issuedLottoPriceEqualsToPaidPrice(int paidMoney, int expected) {
        LottoIssueRequest request = new LottoIssueRequest(LottoMoney.of(paidMoney), Collections.emptyList());

        LottoIssueResponse response = lottoMachine.issue(request);

        assertThat(response.sizeTotal()).isEqualTo(expected);
    }

    @DisplayName("입력한 수동 번호만큼 수동 로또를 발급한다")
    @Test
    void issue_manualLottos() {
        List<Set<Integer>> manualNumbers = Arrays.asList(
                Stream.of(1, 2, 3, 4, 5, 6).collect(toSet()),
                Stream.of(1, 2, 3, 4, 5, 6).collect(toSet())
        );

        LottoIssueRequest request = new LottoIssueRequest(LottoMoney.of(10_000), manualNumbers);

        LottoIssueResponse response = lottoMachine.issue(request);

        assertThat(response.sizeManualLottos()).isEqualTo(manualNumbers.size());
    }
}
