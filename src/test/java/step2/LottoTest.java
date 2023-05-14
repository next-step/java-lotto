package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class LottoTest {

    LottoGame lottoGame = new LottoGame();
    Lotto lotto = new Lotto();

    @DisplayName("로또 숫자는 1~45 사이의 숫자이다.")
    @ParameterizedTest(name = "{0}은 로또 번호에 포함되지 않는다.")
    @ValueSource(ints = {0, 46, 50})
    void 숫자_범위(int num) {
        assertFalse(Lotto.lottoNumber.contains(num));
    }

    @Test
    void 숫자_범위2() {
        List<Ticket> tickets = lottoGame.makeTickets(7000);
        assertFalse(tickets.contains(46));
    }
}
