package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBundleTest {

    @ParameterizedTest
    @CsvSource({"14000, 14", "1000, 1", "0, 0", "-1000, 0"})
    @DisplayName("금액으로 구입 가능한 개수만큼 로또 번 생성")
    void buyTickets(int payment, int count) {
        assertThat(LottoFactory.buyTickets(payment).count()).isEqualTo(count);
    }
}
