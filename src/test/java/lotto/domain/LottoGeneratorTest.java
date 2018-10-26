package lotto.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class LottoGeneratorTest {

    @Test
    public void generateByMoney() {
        Lottos lottos = LottoGenerator.generateByMoney(new Money(5000));
        System.out.println(lottos);
        assertEquals(5, lottos.count());
    }
    
    @Test
    public void generateAuto() throws Exception {
        Lotto lotto = LottoGenerator.generateAuto();
        System.out.println(lotto);
    }

}
