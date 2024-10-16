package lotto;

import lotto.model.Lotto;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {

    private final Lotto lotto = new Lotto();

    @Test
    public void 로또_구매() {
        List<Integer>[] lottos = lotto.purchaseLotto(14);

        assertThat(lottos)
                .hasSize(14);

        Arrays.stream(lottos)
                .map(lotto -> lotto.stream()
                        .map(number -> assertThat(number)
                                .isGreaterThanOrEqualTo(1)
                                .isLessThanOrEqualTo(45)));
    }
}
