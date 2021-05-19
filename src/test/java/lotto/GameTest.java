package lotto;

import lotto.domain.*;
import lotto.domain.generator.LottoNumberGenerator;
import lotto.util.LottoStringFixtureUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    @Test
    @DisplayName("금액을 주어, 로또를 생성하고 결과를 확인한다")
    public void 금액을_주어_로또를_생성하고_결과를_확인한다() {
        PositiveInteger money = new PositiveInteger(6500);
        Game game = Game.createByMoneyAndGenerator(money, createLottoGenerator());
        LottoWon lottoWon = new LottoWon(LottoStringFixtureUtil.convertStringToLottoNumberList("1,2,3,4,5,6"));

        LottoRanks match = game.match(lottoWon);

        assertThat(match.countOf(LottoRank.FIRST))
                .isEqualTo(1);
        assertThat(match.countOf(LottoRank.SECOND))
                .isEqualTo(1);
        assertThat(match.countOf(LottoRank.THIRD))
                .isEqualTo(1);
        assertThat(match.countOf(LottoRank.FOURTH))
                .isEqualTo(1);
        assertThat(match.countOf(LottoRank.MISS))
                .isEqualTo(2);
    }

    public LottoNumberGenerator createLottoGenerator() {
        return new LottoNumberGenerator() {
            private int index = 0;

            @Override
            public Set<LottoNumber> generate() {
                index++;

                if (index == 1) {
                    return new HashSet(LottoStringFixtureUtil.convertStringToLottoNumberList("1,2,3,4,5,6"));
                } else if (index == 2) {
                    return new HashSet(LottoStringFixtureUtil.convertStringToLottoNumberList("11,2,3,4,5,6"));
                } else if (index == 3) {
                    return new HashSet(LottoStringFixtureUtil.convertStringToLottoNumberList("11,12,3,4,5,6"));
                } else if (index == 4) {
                    return new HashSet(LottoStringFixtureUtil.convertStringToLottoNumberList("11,12,13,4,5,6"));
                } else if (index == 5) {
                    return new HashSet(LottoStringFixtureUtil.convertStringToLottoNumberList("11,12,13,14,5,6"));
                } else if (index == 6) {
                    return new HashSet(LottoStringFixtureUtil.convertStringToLottoNumberList("11,12,13,14,15,6"));
                }

                return null;
            }
        };
    }
}
