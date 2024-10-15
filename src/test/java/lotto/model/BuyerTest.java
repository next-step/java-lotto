package lotto.model;

import lotto.fixture.BuyerFixtureNumberCreator;
import lotto.model.dto.LottoNumber;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.model.dto.LottoNumber.of;
import static org.assertj.core.api.Assertions.assertThat;

public class BuyerTest {

    @Test
    void 구매자의_로또목록을_출력한다() {
        Buyer buyer = Buyer.of(
                2,
                new BuyerFixtureNumberCreator(List.of(
                        List.of(of(8), of(21), of(23), of(41), of(42), of(43)),//111111-1
                        List.of(of(1), of(8), of(11), of(31), of(41), of(42))//111-5
                )),
                () -> of(3)
        );

        List<List<LottoNumber>> actual = buyer.value()
                .stream()
                .map(Lotto::numbers)
                .collect(Collectors.toUnmodifiableList());
        List<List<LottoNumber>> expected = List.of(
                List.of(of(8), of(21), of(23), of(41), of(42), of(43)),//111111-1
                List.of(of(1), of(8), of(11), of(31), of(41), of(42))//111-5
        );

        assertThat(actual).containsExactlyElementsOf(expected);
    }

}