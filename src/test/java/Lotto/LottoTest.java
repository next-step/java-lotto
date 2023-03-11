package Lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static Lotto.LottoRank.FIRST_RANK;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @DisplayName(value = "랜덤 로또 숫자를 반환한다. (로또 숫자는 6개까지 리턴)")
    @Test
    void getLottoNumbers() {
        Lotto lotto = Lotto.createLotto();
        assertThat(lotto.getLottoNumbers().size()).isSameAs(6);
        //System.out.println(lotto.getLottoNumbers().toString());
    }

    @DisplayName(value = "구매 금액을 입력하면 해당 금액에 해당하는 장수의 로또 숫자를 반환한다.")
    @Test
    void getLottoCount() {
        Lottos lottos = new Lottos();
        lottos.buyLottos(new BigDecimal("100000"));
        assertThat(lottos.getLottoCount()).isSameAs(100);
        //System.out.println(lotto.getLottoNumbers().toString());
    }

    @DisplayName(value = "일치하는 갯수 및 보너스숫자 여부에 따라 당첨금액을 반환한다.")
    @Test
    void getRankInformation() {
        Lotto lotto = Lotto.createLotto();
        lotto.setRank(LottoRank.findRank(6, false));
        assertThat(lotto.getRank().getRewardAmount()).isEqualTo(new BigDecimal("2000000000"));
    }
}
