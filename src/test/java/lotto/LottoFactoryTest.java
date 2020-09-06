package lotto;

import lotto.domain.LottoFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoFactoryTest {

    @Test
    @DisplayName("정상적으로 로또 묶음과 번호가 생성되는지 확인")
    void buyTickets() {
        assertNotNull(LottoFactory.buyTickets(3000));
    }
}
