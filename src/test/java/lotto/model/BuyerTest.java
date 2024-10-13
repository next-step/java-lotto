package lotto.model;

import lotto.fixture.BuyerFixtureNumberCreator;
import lotto.model.dto.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.fixture.BuyerFixture.*;
import static lotto.fixture.LottoFixture.WINNING_LOTTO_NUMBERS;
import static org.assertj.core.api.Assertions.assertThat;

public class BuyerTest {

    @Test
    void 구매자의_로또목록을_출력한다() {
        Buyer buyer = Buyer.of(LOTTOES_BUY_COUNT_FIXTURE, new BuyerFixtureNumberCreator(LOTTOES_NUMBERS));

        List<Lotto> value = buyer.value();
        List<List<LottoNumber>> actual = value.stream()
                .map(Lotto::numbers)
                .collect(Collectors.toUnmodifiableList());

        assertThat(actual).containsExactlyElementsOf(LOTTOES_NUMBERS);
    }

    @Test
    void 구매한_로또번호_6자리_목록의_등수들을_리턴한다() {
        Buyer buyer = Buyer.of(LOTTOES_BUY_COUNT_FIXTURE, new BuyerFixtureNumberCreator(LOTTOES_NUMBERS));
        Lotto winningLotto = Lotto.of(() -> WINNING_LOTTOES_NUMBERS);

        String actual = buyer.rankings(winningLotto).result();
        String expected = "3개 일치 (5000원)- 1개\n" +
                "4개 일치 (50000원)- 0개\n" +
                "5개 일치 (1500000원)- 0개\n" +
                "6개 일치 (2000000000원)- 1개";

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}