package lotto;

import lotto.model.LottoBuyer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoBuyerTest {

    private final LottoBuyer lottoBuyer = new LottoBuyer(14);

    @Test
    public void 로또_저장() {
        lottoBuyer.saveLotto(0, new ArrayList<>(List.of(15, 23, 13, 44, 5, 34)));
        lottoBuyer.saveLotto(1, new ArrayList<>(List.of(5, 41, 23, 38, 9, 26)));

        assertThat(lottoBuyer.giveLottos()[0]).isEqualTo(List.of(15, 23, 13, 44, 5, 34));
        assertThat(lottoBuyer.giveLottos()[1]).isEqualTo(List.of(5, 41, 23, 38, 9, 26));
    }
}
