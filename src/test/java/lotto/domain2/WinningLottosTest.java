package lotto.domain2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottosTest {

    @Test
    void 생성() {
        final List<LottoNumber> numbers = Arrays.asList(
            LottoNumber.of(1),
            LottoNumber.of(2),
            LottoNumber.of(3),
            LottoNumber.of(4),
            LottoNumber.of(5),
            LottoNumber.of(6)
        );

        Lottos lottos = new Lottos(Collections.singletonList(new Lotto(numbers)));

        WinningLottos winningLottos = new WinningLottos(lottos);
        assertThat(winningLottos).isEqualTo(new WinningLottos(lottos));

    }
}
