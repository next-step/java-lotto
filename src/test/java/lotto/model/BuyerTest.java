package lotto.model;

import lotto.fixture.BuyerFixtureNumberCreator;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.fixture.BuyerFixture.LOTTOES_AMOUNT_FIXTURE;
import static lotto.fixture.BuyerFixture.LOTTOES_FIXTURE;
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
        List<Integer[]> actual = value
                .stream()
                .map(lotto -> lotto.numbers().toArray(Integer[]::new))
                .collect(Collectors.toUnmodifiableList());

        assertThat(actual).containsExactlyElementsOf(LOTTOES_FIXTURE);
    }

}
