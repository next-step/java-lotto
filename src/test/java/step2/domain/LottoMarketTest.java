package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.strategy.LottoNumStrategy;
import step2.strategy.RandomLottoNum;

import java.util.Arrays;

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

    @DisplayName("로또 번호 확인하기")
    @Test
    void checkLottoNumTest(){
        LottoList list = LottoList.create();
        LottoNumStrategy strategy = new LottoNumStrategy() {
            @Override
            public Lotto makeLotto() {
                return Lotto.from(Arrays.asList(1,2,3,4,5,6));
            }
        };
        LottoMachine machine = LottoMachine.of(strategy);

        LottoMarket market = new LottoMarket(machine, list);

        market.buy(1000);

        assertThat(market.checkNumToWinner(Lotto.from(Arrays.asList(1,2,3,4,5,6))).get(0))
                .isEqualTo(Winnings.FIRST);
    }

}