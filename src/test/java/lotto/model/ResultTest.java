package lotto.model;

import lotto.fixture.BuyerFixtureNumberCreator;
import lotto.model.dto.LottoNumber;
import lotto.model.enums.Ranking;
import lotto.util.BonusCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static lotto.model.dto.LottoNumber.of;
import static lotto.model.enums.Ranking.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    private Buyer buyer;
    private Lotto winningLotto;

    @BeforeEach
    void setUp() {
        this.buyer = Buyer.of(
                2,
                new BuyerFixtureNumberCreator(List.of(
                        List.of(of(8), of(21), of(23), of(41), of(42), of(43)),
                        List.of(of(1), of(8), of(11), of(31), of(41), of(42))
                )),
                () -> of(3));
        this.winningLotto = Lotto.of(
                () -> List.of(of(8), of(21), of(23), of(41), of(42), of(43)),
                () -> of(3));
    }

    @Test
    void 수익률을_출력한다() {
        Result result = Result.of(buyer, winningLotto);

        double actual = result.statistics(2);
        double expected =
                (Long.valueOf(2000000000L).doubleValue() + Long.valueOf(5000L).doubleValue()) /
                        Integer.valueOf(2000).doubleValue();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 구매한_로또번호_6자리_목록의_등수들을_리턴한다() {
        Map<Ranking, Integer> actual = Result.of(buyer, winningLotto).rankings();
        Map<Ranking, Integer> expected = Map.of(FOURTH, 1,
                THIRD, 0,
                SECOND, 0,
                FIRST, 1);

        assertThat(actual).isEqualTo(expected);
    }

}
