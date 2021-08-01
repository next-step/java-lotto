package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.strategy.RandomLottoNum;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoMarketTest {

    @DisplayName("로또 갯수만큼 사기")
    @Test
    void countLottoList(){
        LottoList list = LottoList.create();
        LottoMachine machine = LottoMachine.of(new RandomLottoNum());

        LottoMarket market = new LottoMarket(machine, list);

        market.buy(6000);

        assertThat(list.getSize()).isEqualTo(6);
    }

}