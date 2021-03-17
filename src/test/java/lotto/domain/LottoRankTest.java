package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRankTest {

    private int amount;
    private LottoMachine lottoMachine;

    @BeforeEach
    public void setUp() {
        amount = 10000;
        lottoMachine = new LottoMachine(amount);
    }

    @Test
    @DisplayName("로또 당첨 생성 확인")
    public void lottoRankTest() throws Exception {
        //given
        LottoRank lottoRank = new LottoRank(lottoMachine);
        
        //when

        //then
        
    }
}
