package lotto.model;

import lotto.fixture.BuyerFixtureNumberCreator;
import lotto.model.enums.Ranking;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.fixture.BuyerFixture.LOTTOES_AMOUNT_FIXTURE;
import static lotto.fixture.BuyerFixture.LOTTOES_FIXTURE;
import static lotto.fixture.SellerFixtrue.WINNING_FIXTURE;
import static lotto.model.enums.Ranking.*;
import static org.assertj.core.api.Assertions.assertThat;

public class BuyerTest {

    @Test
    void 구매자의_로또목록의_size_를_출력한다() {
        Buyer buyer = Buyer.of(LOTTOES_AMOUNT_FIXTURE, new BuyerFixtureNumberCreator(LOTTOES_FIXTURE));

        int actual = buyer.size();

        assertThat(actual).isEqualTo(LOTTOES_AMOUNT_FIXTURE);
    }

    @Test
    void 구매자의_로또목록의_value_를_출력한다() {
        Buyer buyer = Buyer.of(LOTTOES_AMOUNT_FIXTURE, new BuyerFixtureNumberCreator(LOTTOES_FIXTURE));

        List<Lotto> value = buyer.value();
        List<Integer[]> actual = value.stream()
                .map(lotto -> lotto.numbers().toArray(Integer[]::new))
                .collect(Collectors.toUnmodifiableList());

        assertThat(actual).containsExactlyElementsOf(LOTTOES_FIXTURE);
    }

    @Test
    void 구매한_로또번호_6자리_목록의_등수들을_결과로_출력한다() {
        Buyer buyer = Buyer.of(LOTTOES_AMOUNT_FIXTURE, new BuyerFixtureNumberCreator(LOTTOES_FIXTURE));
        Seller seller = Seller.of(Lotto.of(() -> WINNING_FIXTURE));

        Map<Ranking, Integer> actual = buyer.rankings(seller);
        Map<Ranking, Integer> expected = Map.of(
                NONE, 12,
                FOURTH, 1,
                THIRD, 0,
                SECOND, 0,
                FIRST, 1
        );

        Assertions.assertThat(actual).isEqualTo(expected);

    }
}
