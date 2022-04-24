package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LotteriesTest {

    private List<Lotto> userLottoNumber;

    @BeforeEach
    void setUp() {
        userLottoNumber = Arrays.asList(
                new Lotto(1),
                new Lotto(2),
                new Lotto(3),
                new Lotto(4),
                new Lotto(5),
                new Lotto(6));
    }

    @Test
    void create() {
        assertThat(new Lotteries(userLottoNumber)).isEqualTo(new Lotteries(userLottoNumber));
    }

}
