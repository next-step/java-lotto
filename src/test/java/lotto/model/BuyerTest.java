package lotto.model;

import lotto.fixture.BuyerFixtureNumberCreator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BuyerTest {

    @Test
    void 구매자의_로또목록을_출력한다() {
        int[] lotto1 = new int[]{8, 21, 23, 41, 42, 43};
        int[] lotto2 = new int[]{1, 8, 11, 31, 41, 42};

        Buyer buyer = new Buyer(2, new BuyerFixtureNumberCreator(Arrays.asList(lotto1, lotto2)));

        List<Lotto> actual = buyer.value();
        List<Lotto> expected = Arrays.asList(new Lotto(lotto1), new Lotto(lotto2));

        assertThat(actual).isEqualTo(expected);
    }
}