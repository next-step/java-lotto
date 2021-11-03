package lotto.domains;

import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    void 로또번호_생성하기() {
        Lotto lotto = new Lotto();
        System.out.println(lotto.toString());
    }
}
