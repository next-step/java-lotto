package step2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoIssuerTest {

    @Test
    public void issue() {
        LottoIssuer lottoIssuer = new LottoIssuer();
        List<Lotto> list = lottoIssuer.issue(13500);
        assertEquals(list.size(), 13);
    }
}
