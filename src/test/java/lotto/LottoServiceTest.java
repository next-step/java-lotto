package lotto;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import lotto.service.LottoService;
import lotto.domain.game.Payment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    @DisplayName("로또 서비스 객체 생성")
    @Test
    void 로또_서비스_객체_생성() {
        Payment payment = new Payment("3000");

        assertDoesNotThrow(() -> new LottoService(payment));
    }

}
