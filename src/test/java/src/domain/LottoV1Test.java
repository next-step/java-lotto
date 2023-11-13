package src.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoV1Test {

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "1500:1", "5110:5", "15450:15"}, delimiter = ':')
    void 금액에_따라_로또를_발급할_수_있다(int inputMoney, int expectedCount) {
        // when
        Money money = new Money(inputMoney);
        LottoV1 lottoV1 = money.buyLotto();

        // then
        assertThat(lottoV1.gameCount()).isEqualTo(expectedCount);
    }

    @Test
    void 로또_매치_결과를_얻을_수_있다() {
        // given
        LottoV1 lottoV1 = LottoV1.lotto(10);
        Game winningGame = Game.byGameNumbers(Set.of(
                GameNumber.of(4), GameNumber.of(5), GameNumber.of(6),
                GameNumber.of(7), GameNumber.of(8), GameNumber.of(9)
        ));
        lottoV1.match(winningGame);

        // when
        MatchStatus matchStatus = lottoV1.matchStatus();

        // then
        assertThat(matchStatus).isNotNull();
    }

    @Test
    void 로또의_수익률을_확인할_수_있다() {
        // given
        /**
         * 로또를 2(2000원)개 구매하고 4등 (5000원) 당첨 케이스
         */
        Game fourthPlaceGame = Game.byGameNumbers(Set.of(
                GameNumber.of(4), GameNumber.of(5), GameNumber.of(6),
                GameNumber.of(7), GameNumber.of(8), GameNumber.of(9)
        ));

        Game otherGame = Game.byGameNumbers(Set.of(
                GameNumber.of(45), GameNumber.of(44), GameNumber.of(43),
                GameNumber.of(42), GameNumber.of(41), GameNumber.of(40)
        ));
        LottoV1 lottoV1 = LottoV1.byGames(new Games(List.of(fourthPlaceGame, otherGame)));

        Game winningGame = Game.byGameNumbers(Set.of(
                GameNumber.of(1), GameNumber.of(2), GameNumber.of(3),
                GameNumber.of(4), GameNumber.of(5), GameNumber.of(6)
        ));
        double expectedProfitRate = 2.5;
        lottoV1.match(winningGame);

        // when
        double profitRate = lottoV1.profitRate();

        // then
        assertThat(profitRate).isEqualTo(expectedProfitRate);
    }
}
