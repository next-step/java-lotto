package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    void profitRate_수익률() {
        Lottos lottos = new Lottos(createLottos());
        Lotto winningNumbers = createLotto(new int[]{1, 2, 3, 4, 5, 6});
        LottoResult result = lottos.result(winningNumbers);
        assertThat(result.profitRate()).isEqualTo(0.35);

    }

    private static List<Lotto> createLottos() {
        return Arrays.asList(
                createLotto(new int[]{8, 21, 23, 41, 42, 43}),
                createLotto(new int[]{3, 5, 11, 16, 32, 38}),
                createLotto(new int[]{7, 11, 16, 35, 36, 44}),
                createLotto(new int[]{1, 8, 11, 31, 41, 42}),
                createLotto(new int[]{13, 14, 16, 38, 42, 45}),
                createLotto(new int[]{7, 11, 30, 40, 42, 43}),
                createLotto(new int[]{2, 13, 22, 32, 38, 45}),
                createLotto(new int[]{23, 25, 33, 36, 39, 41}),
                createLotto(new int[]{1, 3, 5, 14, 22, 45}),
                createLotto(new int[]{5, 9, 38, 41, 43, 44}),
                createLotto(new int[]{2, 8, 9, 18, 19, 21}),
                createLotto(new int[]{13, 14, 18, 21, 23, 35}),
                createLotto(new int[]{17, 21, 29, 37, 42, 45}),
                createLotto(new int[]{3, 8, 27, 30, 35, 44})
        );
    }

    private static Lotto createLotto(int[] ints) {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                new LottoNumber(ints[0]),
                new LottoNumber(ints[1]),
                new LottoNumber(ints[2]),
                new LottoNumber(ints[3]),
                new LottoNumber(ints[4]),
                new LottoNumber(ints[5]));

        return new Lotto(lottoNumbers);
    }


}
