package lotto.model;

import lotto.fixture.BuyerFixtureNumberCreator;
import lotto.model.dto.LottoNumber;
import lotto.model.enums.Ranking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static lotto.model.dto.LottoNumber.of;
import static lotto.model.enums.Ranking.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    private Buyer buyer;
    private Winning winning;

    @BeforeEach
    void setUp() {
        this.buyer = Buyer.of(
                3,
                new BuyerFixtureNumberCreator(List.of(
                        List.of(of(8), of(21), of(23), of(41), of(42), of(43)),
                        List.of(of(8), of(21), of(23), of(41), of(42), of(44)),
                        List.of(of(1), of(8), of(11), of(31), of(41), of(42))
                )));
        Lotto winningLotto = Lotto.of(
                () -> List.of(of(8), of(21), of(23), of(41), of(42), of(43))
        );
        LottoNumber bonusNumber = of(44);
        this.winning = Winning.of(winningLotto, bonusNumber);
    }

    @Test
    void 수익률을_출력한다() {
        Result result = Result.of(buyer, winning);

        double actual = result.statistics(3);

        double expectedSum = Long.valueOf(2_000_000_000).doubleValue() +
                Long.valueOf(30_000_000).doubleValue() +
                Long.valueOf(5_000).doubleValue();
        double expectedDivider = Integer.valueOf(3000).doubleValue();
        double expected = expectedSum / expectedDivider;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 구매한_로또번호_6자리_목록의_등수들을_리턴한다() {
        Map<Ranking, Integer> actual = Result.of(buyer, winning).rankings();
        Map<Ranking, Integer> expected = Map.of(
                FIFTH, 1,
                FOURTH, 0,
                THIRD, 0,
                SECOND, 1,
                FIRST, 1);

        assertThat(actual).isEqualTo(expected);
    }

}
