package lotto.model;

import lotto.fixture.BuyerFixtureNumberCreator;
import lotto.model.dto.LottoNumber;
import lotto.model.enums.Ranking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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
        this.buyer = new Buyer(
                3,
                new BuyerFixtureNumberCreator(Arrays.asList(
                        Arrays.asList(of(8), of(21), of(23), of(41), of(42), of(43)),
                        Arrays.asList(of(8), of(21), of(23), of(41), of(42), of(44)),
                        Arrays.asList(of(1), of(8), of(11), of(31), of(41), of(42))
                )));
        Lotto winningLotto = new Lotto(
                () -> Arrays.asList(of(8), of(21), of(23), of(41), of(42), of(43))
        );
        LottoNumber bonusNumber = of(44);
        this.winning = new Winning(winningLotto, bonusNumber);
    }

    @Test
    void 수익률을_출력한다() {
        Result result = new Result(buyer, winning);

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
        Map<Ranking, Integer> actual = new Result(buyer, winning).rankings();
        Map<Ranking, Integer> expected = Map.of(
                FIFTH, 1,
                FOURTH, 0,
                THIRD, 0,
                SECOND, 1,
                FIRST, 1);

        assertThat(actual).isEqualTo(expected);
    }

}
