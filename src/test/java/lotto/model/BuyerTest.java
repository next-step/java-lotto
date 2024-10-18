package lotto.model;

import lotto.fixture.BuyerFixtureNumberCreator;
import lotto.model.dto.LottoNumber;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.model.dto.LottoNumber.of;
import static org.assertj.core.api.Assertions.assertThat;

public class BuyerTest {

    @Test
    void 구매자의_로또목록을_출력한다() {
        Buyer buyer = Buyer.of(
                2,
                new BuyerFixtureNumberCreator(Arrays.asList(
                        Arrays.asList(of(8), of(21), of(23), of(41), of(42), of(43)),
                        Arrays.asList(of(1), of(8), of(11), of(31), of(41), of(42))
                ))
        );

        List<Lotto> actual = buyer.value();
        List<Lotto> expected = Arrays.asList(
                new Lotto(() -> Arrays.asList(of(8), of(21), of(23), of(41), of(42), of(43))),
                new Lotto(() -> Arrays.asList(of(1), of(8), of(11), of(31), of(41), of(42)))
        );

        assertThat(actual).isEqualTo(expected);
    }
}