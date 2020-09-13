package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lotto;
import step2.domain.LottoIssuer;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoIssuerTest {

    @Test
    @DisplayName("로또 발급 횟수 체크")
    public void issue() {
        LottoIssuer lottoIssuer = new LottoIssuer();
        List<Lotto> list = lottoIssuer.issue(13500);
        assertEquals(list.size(), 13);
    }
}
