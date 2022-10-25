package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("로또 생성 중복 확인")
    void auto() {
        // given
        Lotto lotto = new Lotto();

        // expected
        assertThat(lotto.getLottoNumbers()).isEqualTo(lotto.getLottoNumbers());
    }

    @Test
    @DisplayName("로또 랭크 확인")
    void rank() {
        // given
        LottoNumbers lottoNumbers = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));
        LottoNumbers winnerLottoNumbers = new LottoNumbers(List.of(1, 2, 3, 10, 12, 13));

        // when
        Lotto lotto = new Lotto(lottoNumbers);
        Rank rank = lotto.rank(winnerLottoNumbers);

        // then
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }
}
