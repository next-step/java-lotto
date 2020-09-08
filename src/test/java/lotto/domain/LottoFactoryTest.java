package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LottoFactoryTest {

    @Test
    @DisplayName("정상적으로 로또 묶음과 번호가 생성되는지 확인")
    void buyTickets() {
        assertNotNull(LottoFactory.buyTickets(3000));
    }

    @ParameterizedTest
    @CsvSource({"14000, 14", "1000, 1", "0, 0", "-1000, 0"})
    @DisplayName("금액으로 구입 가능한 개수만큼 로또 번 생성")
    void buyTickets(int payment, int count) {
        assertEquals(LottoFactory.buyTickets(payment).size(), count);
    }
}
