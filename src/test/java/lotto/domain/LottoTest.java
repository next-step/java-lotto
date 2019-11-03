package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @ParameterizedTest
    @CsvSource(value = {"14000:14", "20000:20", "5500:5"}, delimiter = ':')
    @DisplayName("금액 입력받아 몇개 구매하는지 리턴한다.")
    void buyTicket(int amount, int result) {

        Lotto lotto = new Lotto();

        assertThat(lotto.buyTicket(amount)).isEqualTo(result);
    }
}
