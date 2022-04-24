package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LotteriesTest {

    private List<Lotto> userLotteries;
    private List<Lotto> invalidCountLotteries;

    @BeforeEach
    void setUp() {
        userLotteries = Arrays.asList(
                new Lotto(1),
                new Lotto(2),
                new Lotto(3),
                new Lotto(4),
                new Lotto(5),
                new Lotto(6));

        invalidCountLotteries = Arrays.asList(
                new Lotto(1),
                new Lotto(2),
                new Lotto(3),
                new Lotto(4),
                new Lotto(5),
                new Lotto(5)
        );
    }

    @Test
    void create() {
        assertThat(new Lotteries(userLotteries)).isEqualTo(new Lotteries(userLotteries));
    }

    @Test
    @DisplayName("로또 1개의 집합은 중복 없이 6개의 숫자로 이루어져 있어야 합니다.")
    void invalidLottoSet() {
        assertThatThrownBy(() -> new Lotteries(invalidCountLotteries))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
