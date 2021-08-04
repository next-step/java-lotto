package lotto.action;

import lotto.action.LottoMachine;
import lotto.action.LottoMarket;
import lotto.domain.Lotteries;
import lotto.domain.Lotto;
import lotto.domain.Winning;
import lotto.strategy.LottoNumStrategy;
import lotto.strategy.RandomLottoNum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMarketTest {

    @DisplayName("로또 갯수만큼 사기")
    @Test
    void countLottoList(){
        Lotteries list = Lotteries.create();
        LottoMachine machine = LottoMachine.of(new RandomLottoNum());

        LottoMarket market = new LottoMarket(machine, list);

        market.buy(6000);

        assertThat(list.getSize()).isEqualTo(6);
    }

    @DisplayName("로또 번호 확인하기")
    @Test
    void checkLottoNumTest(){
        Lotteries list = Lotteries.create();
        LottoNumStrategy strategy = new LottoNumStrategy() {
            @Override
            public Lotto makeLotto() {
                return Lotto.from(Arrays.asList(1,2,3,4,5,6));
            }
        };
        LottoMachine machine = LottoMachine.of(strategy);

        LottoMarket market = new LottoMarket(machine, list);

        market.buy(1000);

        assertThat(market.checkNumToWinner(Lotto.from(Arrays.asList(1,2,3,4,5,6)),7).get(Winning.FIRST))
                .isEqualTo(1);
    }

}