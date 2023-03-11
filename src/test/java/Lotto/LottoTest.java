package Lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @DisplayName(value = "랜덤 로또 숫자를 반환한다. (로또 숫자는 6개까지 리턴)")
    @Test
    void getLottoNumbers() {
        Lotto lotto = Lotto.createAutoLotto();
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
        Integer[] arr = { 1,2,3,4,5,6 };
        Integer[] arr2 = { 1,2,3,7,8,9 };
        Lotto lotto = Lotto.createManualLotto(Arrays.asList(arr));
        Lotto winLotto = Lotto.createManualLotto(Arrays.asList(arr2));
        lotto.setHitCount(winLotto);
        lotto.setIsBonusHit(7);
        lotto.setRank();
        assertThat(lotto.getRank().getRewardAmount()).isEqualTo(new BigDecimal("5000"));
    }

    @DisplayName(value = "로또 세트에 당첨 번호를 입력하면 각 세트별 일치하는 숫자의 갯수를 반환한다.")
    @Test
    void setHitCount() {
        Integer[] arr = { 1,2,3,4,5,6 };
        Integer[] arr2 = { 1,2,3,7,8,9 };
        Lotto lotto = Lotto.createManualLotto(Arrays.asList(arr));
        Lotto winLotto = Lotto.createManualLotto(Arrays.asList(arr2));
        lotto.setHitCount(winLotto);
        assertThat(lotto.getHitCount()).isEqualTo(3);
    }

    @DisplayName(value = "로또 세트에 보너스 숫자가 포함되어 있으면 true를 반환한다.")
    @Test
    void setWinInformation() {
        Integer[] arr = { 1,2,3,4,5,6 };
        Lotto lotto = Lotto.createManualLotto(Arrays.asList(arr));
        lotto.setIsBonusHit(3);
        assertThat(lotto.getIsBonusHit()).isEqualTo(true);
    }
}
