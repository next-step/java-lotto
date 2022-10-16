package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.LottoNumber.lottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    @DisplayName("로또 자동 발급 수 검증")
    void automaticIssue() {
        assertThat(new LottoMachine(lottoNumbers()).automaticIssue(10)).hasSize(10);
    }
}
