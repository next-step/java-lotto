package lotto.domain;

import lotto.domain.generator.LottoNumberGenerator;
import lotto.domain.rank.LottoRank;
import lotto.domain.rank.LottoRanks;
import lotto.util.LottoStringFixtureUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static lotto.util.LottoStringFixtureUtil.convertStringToLottoNumberList;
import static lotto.util.LottoStringFixtureUtil.lottoNumbersSortedByRank;
import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    @Test
    @DisplayName("금액을 주어, 로또를 생성하고 결과를 확인한다")
    public void 금액을_주어_로또를_생성하고_결과를_확인한다() {
        int ticketSize = 8;
        int dummyMoney = 500;
        int moneyInHand = ticketSize * 1000 + dummyMoney;

        PositiveNumber money = new PositiveNumber(moneyInHand);
        Game game = Game.createByMoneyAndGenerator(money, createLottoGenerator());
        LottoWon lottoWon = new LottoWon(convertStringToLottoNumberList("1,2,3,4,5,6"), LottoNumber.of(7));

        LottoRanks match = game.match(lottoWon);

        assertThat(match.countOf(LottoRank.FIRST))
                .isEqualTo(1);
        assertThat(match.countOf(LottoRank.SECOND))
                .isEqualTo(1);
        assertThat(match.countOf(LottoRank.THIRD))
                .isEqualTo(1);
        assertThat(match.countOf(LottoRank.FOURTH))
                .isEqualTo(1);
        assertThat(match.countOf(LottoRank.FIFTH))
                .isEqualTo(1);
        assertThat(match.countOf(LottoRank.MISS))
                .isEqualTo(3);
    }

    public LottoNumberGenerator createLottoGenerator() {
        return new LottoNumberGenerator() {
            private int index = 0;

            @Override
            public Set<LottoNumber> generate() {
                index++;

                String[] lottoNumbersSortedByRank = lottoNumbersSortedByRank();
                return convertStringToLottoNumberList(lottoNumbersSortedByRank[index]);
            }
        };
    }
}
