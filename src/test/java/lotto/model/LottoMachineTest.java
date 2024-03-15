package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @DisplayName("선택가능한 로또 번호는 45개가 있다")
    @Test
    void size() {
        assertThat(LottoMachine.size()).isEqualTo(45);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0", "999:0", "1000:1", "14001:14"}, delimiter = ':')
    void purchase(int given, int expected) {
        List<Lotto> lotto = LottoMachine.purchase(given);
        assertThat(lotto).hasSize(expected);
    }
}
