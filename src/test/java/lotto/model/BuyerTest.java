package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BuyerTest {

    @Test
    void 로또목록을_구매자에_저장한다() {
        Assertions.assertThatNoException().isThrownBy(() -> {
            Buyer buyer = Buyer.of(LOTTOES_FIXTURE);
        });
    }

    @Test
    void 구매자의_로또목록의_size_를_출력한다() {
        Buyer buyer = Buyer.of(LOTTOES_FIXTURE);

        int actual = buyer.size();
        int expected = 2;

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 구매자의_로또목록의_value_를_출력한다() {
        Buyer buyer = Buyer.of(LOTTOES_FIXTURE);

        List<Lotto> actual = buyer.value();
        List<Lotto> expected = LOTTOES_FIXTURE;

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    public static final List<Lotto> LOTTOES_FIXTURE = List.of(
            Lotto.of(8, 21, 23, 41, 42, 43),
            Lotto.of(2, 13, 22, 32, 38, 45)
    );
}
