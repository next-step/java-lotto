package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("로또 발급 수 검증")
    void issueLotto() {
        UserInput input = new UserInput(10000);
        assertThat(new Lotto().lottoMachine(input).size()).isEqualTo(10);
    }
}
