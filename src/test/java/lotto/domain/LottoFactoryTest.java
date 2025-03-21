package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoFactoryTest {

    private final LottoFactory lottoFactory = new LottoFactory();

    @Test
    void createLottoTest() {
        Lotto lotto = lottoFactory.createLotto();
        System.out.println(lotto);
    }
}
