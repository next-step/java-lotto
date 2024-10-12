package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.model.Buyer.LOTTO_IS_NOT_ALLOWED_DUPLICATED;

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

    @Test
    void 로또목록은_중복될수_없다() {
        Assertions.assertThatThrownBy(() -> {
                    Buyer duplicateBuyLottoesBuyer = Buyer.of(LOTTOES_DUPLICATED_FIXTURE);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_IS_NOT_ALLOWED_DUPLICATED);
    }

    @Test
    void 로또목록과_당첨로또를_비교한다() {

    }

    public static final List<Lotto> LOTTOES_FIXTURE;

    static {
        LOTTOES_FIXTURE = List.of(
                Lotto.of(() -> new Integer[]{8, 21, 23, 41, 42, 43}),
                Lotto.of(() -> new Integer[]{2, 13, 22, 32, 38, 45})
        );
    }

    public static final List<Lotto> LOTTOES_DUPLICATED_FIXTURE = List.of(
            Lotto.of(() -> new Integer[]{8, 21, 23, 41, 42, 43}),
            Lotto.of(() -> new Integer[]{21, 8, 23, 41, 42, 43})
    );
}
