package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.LottoNumber.lottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    @DisplayName("로또 발급 검증")
    void issue() {
        assertThat(new LottoMachine(lottoNumbers()).automaticIssue(10).size()).isEqualTo(10);
    }
}
