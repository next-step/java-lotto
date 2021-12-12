package lotto.domain;

import lotto.domain.fixture.TestLottoFactory;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    void profitRate_수익률() {
        Lottos lottos = new Lottos(createLottos());
        Lotto winningNumbers = TestLottoFactory.create(new int[]{1, 2, 3, 4, 5, 6});
        LottoResult result = lottos.result(winningNumbers, LottoNumber.of(7));
        assertThat(result.profitRate()).isEqualTo(0.35);

    }

    private static List<Lotto> createLottos() {
        return Arrays.asList(
                TestLottoFactory.create(new int[]{8, 21, 23, 41, 42, 43}),
                TestLottoFactory.create(new int[]{3, 5, 11, 16, 32, 38}),
                TestLottoFactory.create(new int[]{7, 11, 16, 35, 36, 44}),
                TestLottoFactory.create(new int[]{1, 8, 11, 31, 41, 42}),
                TestLottoFactory.create(new int[]{13, 14, 16, 38, 42, 45}),
                TestLottoFactory.create(new int[]{7, 11, 30, 40, 42, 43}),
                TestLottoFactory.create(new int[]{2, 13, 22, 32, 38, 45}),
                TestLottoFactory.create(new int[]{23, 25, 33, 36, 39, 41}),
                TestLottoFactory.create(new int[]{1, 3, 5, 14, 22, 45}),
                TestLottoFactory.create(new int[]{5, 9, 38, 41, 43, 44}),
                TestLottoFactory.create(new int[]{2, 8, 9, 18, 19, 21}),
                TestLottoFactory.create(new int[]{13, 14, 18, 21, 23, 35}),
                TestLottoFactory.create(new int[]{17, 21, 29, 37, 42, 45}),
                TestLottoFactory.create(new int[]{3, 8, 27, 30, 35, 44})
        );
    }

}
