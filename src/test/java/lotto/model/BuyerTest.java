package lotto.model;

import lotto.util.LottoNumbersCreator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BuyerTest {

    public static final int LOTTOES_AMOUNT_FIXTURE = 14;

    @Test
    void 구매자의_로또목록의_size_를_출력한다() {
        Buyer buyer = Buyer.of(LOTTOES_AMOUNT_FIXTURE, new LottoNumbersCreator());

        int actual = buyer.size();

        assertThat(actual).isEqualTo(LOTTOES_AMOUNT_FIXTURE);
    }

    @Test
    void 구매자의_로또목록의_value_를_출력한다() {
        Buyer buyer = Buyer.of(LOTTOES_AMOUNT_FIXTURE, new LottoNumbersCreator());

        int actual = buyer.value().size();

        assertThat(actual).isEqualTo(LOTTOES_AMOUNT_FIXTURE);
    }

}
