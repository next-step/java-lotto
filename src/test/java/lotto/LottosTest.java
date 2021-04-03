package lotto;

import lotto.domain.*;
import lotto.domain.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @DisplayName("Lotto를 구입한 가격만큼 Lotto 갯수 확인")
    @Test
    void lottos() {
        // GIVE
        int payLotto = 14000;
        Lottos lottos;
        // WHEN

        lottos = new Lottos(new LottoGenerator(payLotto));
        // THEN
        assertThat(lottos.getLottos().size()).isEqualTo(14);

    }
}
