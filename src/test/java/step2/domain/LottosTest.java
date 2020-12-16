package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    @DisplayName("조사하고자 하는 Tier와 당첨 로또를 입력받아, Lotto 목록 중 해당 Tier를 가진 개수를 반환한다.")
    void getLottoCountByTier() {
        List<Integer> winningLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto winningLotto = LottoGenerator.generateLotto(winningLottoNumbers);

        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = LottoGenerator.generateLotto(lottoNumbers);

        Lottos lottos = new Lottos(Arrays.asList(lotto));

        assertThat(lottos.getLottoCountByTier(LottoTier.FIRST, winningLotto)).isEqualTo(1);
    }
}
