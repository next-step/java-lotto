package app.action;

import app.domain.*;
import app.domain.lotto.Lotteries;
import app.domain.lotto.Lotto;
import app.domain.lotto.LottoNum;
import app.domain.lotto.WinnerLotto;
import app.strategy.LottoNumStrategy;
import app.strategy.RandomLottoNum;
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

        market.buy(Money.of(6000));

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

        market.buy(Money.of(1000));

        assertThat(market.checkNumToWinner(WinnerLotto.of(Lotto.from(Arrays.asList(1,2,3,4,5,6)), LottoNum.of(7))).get(Winning.FIRST))
                .isEqualTo(1);
    }

}