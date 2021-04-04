package lotto.domain;

import lotto.factories.LottoTicketFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoBuyerTest {
    private LottoStore lottoStore;
    private int payment;

    @BeforeEach
    public void setUp() {
        lottoStore = new LottoStore();
        payment = 10000;
    }

    @Test
    public void create() {
        assertThat(new LottoBuyer(lottoStore, payment)).isEqualTo(new LottoBuyer(lottoStore, payment));
    }


    @ParameterizedTest
    @ValueSource(ints = {-1, 11})
    public void validatePurchasable(int count) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            final LottoBuyer lottoBuyer = new LottoBuyer(lottoStore, payment);

            lottoBuyer.validatePurchasable(count);
        });
    }
}
