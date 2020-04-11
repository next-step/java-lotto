package lotto.domain.lotto;

import lotto.domain.rank.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("로또는 6개의 중복되지 않는 로또 넘버로 생성할 수 있다")
    @Test
    public void lottoCreateTest() {
        Lotto lotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto anotherLotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lotto).isEqualTo(anotherLotto);
    }

    @DisplayName("로또가 가지고 있는 로또 번호는 중복 될 수 없다")
    @Test
    public void lottoNotAllowedDupLottoNumberTest() {
        assertThatThrownBy(() -> Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(LottoSizeException.class)
                .hasMessageContaining("로또 번호는 6개 이어야만 합니다.");
    }

    @DisplayName("로또는 당첨 번호와 보너스 넘버를 입력하면 몇 등인지 알 수 있다")
    @Test
    public void getLottoRankTest() {
        Lotto lotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        LottoNumber bonusNumber = LottoNumber.of(6);

        LottoRank lottoRank = lotto.checkRank(winningNumbers, bonusNumber);

        assertThat(lottoRank.getMatchCount()).isEqualTo(LottoRank.FIVE_BONUS.getMatchCount());
        assertThat(lottoRank.getWinningPrize()).isEqualTo(LottoRank.FIVE_BONUS.getWinningPrize());
    }

}
