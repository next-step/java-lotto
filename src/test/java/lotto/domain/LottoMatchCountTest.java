package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatchCountTest {
    @Test
    void 매치_수() {
        List<Integer> lottoNumbers = List.of(1,2,3,7,8,9);
        Lotto lotto = new Lotto(lottoNumbers);
        List<Integer> winNumbers = new Winning().createWinNumbers("1,2,3,4,5,6");

        assertThat(LottoMatchCount.matchCount(lotto.getLotto(), winNumbers)).isEqualTo(3);
    }
}
