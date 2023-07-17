package lotto;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LottoServiceTest {

    @DisplayName("로또 서비스 객체 생성")
    @Test
    void 로또_서비스_객체_생성() {
        int payment = 14000;
        List<Lotto> manualLottos = new ArrayList<>();

        manualLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        assertDoesNotThrow(() -> new LottoGame(payment, manualLottos));
    }

}
