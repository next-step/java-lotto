package lotto.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBundleTest {
    @Test
    public void LottoBundle_합치기() {
        // given
        Lotto lotto1 = new Lotto(getLottoNumbers(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(getLottoNumbers(1, 2, 3, 4, 5, 6));
        Lotto lotto3 = new Lotto(getLottoNumbers(1, 2, 3, 4, 5, 6));
        LottoBundle lottoBundle = new LottoBundle(Arrays.asList(lotto1, lotto2, lotto3));

        Lotto lotto4 = new Lotto(getLottoNumbers(1, 2, 3, 4, 5, 6));
        Lotto lotto5 = new Lotto(getLottoNumbers(1, 2, 3, 4, 5, 6));
        Lotto lotto6 = new Lotto(getLottoNumbers(1, 2, 3, 4, 5, 6));
        LottoBundle additionalLottoBundle = new LottoBundle(Arrays.asList(lotto4, lotto5, lotto6));

        // when
        lottoBundle.join(additionalLottoBundle);

        // then
        List<Lotto> lottos = lottoBundle.getLottos();
        assertThat(lottos)
                .containsExactly(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6);
    }

    private List<LottoNumber> getLottoNumbers(int... numbers) {
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::getInstance)
                .collect(Collectors.toList());
    }
}
