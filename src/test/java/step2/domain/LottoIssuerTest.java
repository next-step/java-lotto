package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoIssuerTest {

    @Test
    @DisplayName("로또 발급 횟수 체크")
    public void autoissue() {
        List<Lotto> list = LottoIssuer.issueAutoLottos(Money.of(13500).getNumberOfPurchases());
        assertEquals(list.size(), 13);
    }

    @Test
    @DisplayName("수동 로또 발급 횟수 체크")
    public void nonAutoLottoissue() {
        List<Lotto> list = LottoIssuer.issueNonAutoLotto(Arrays.asList("1, 2, 3, 4, 5, 6", "1, 2, 40, 30, 5, 6"));
        assertEquals(list.size(), 2);
    }
}
