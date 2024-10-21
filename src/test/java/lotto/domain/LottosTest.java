package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottosTest {

    @Test
    @DisplayName("1등 당첨 건수 2건")
    void getWinningResult() {
        LottoNumbers lottoNumbers = new LottoNumbers(new int[] {1,2,3,4,5,6});
        Lotto winningLotto = new Lotto(lottoNumbers);
        WinningLotto winningLottoWithBonus = new WinningLotto(winningLotto, new LottoNumber(20));
        Lottos lottos = getLottos(Arrays.asList(lottoNumbers, lottoNumbers));

        WinningResult result = lottos.getWinningResult(winningLottoWithBonus);
        assertThat(result.getRankCount(LottoRankEnum.FIRST)).isEqualTo(2);
    }

    private Lottos getLottos(List<LottoNumbers> lottoList) {
        return new Lottos(lottoList);
    }

}
