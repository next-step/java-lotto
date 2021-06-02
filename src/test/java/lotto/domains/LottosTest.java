package lotto.domains;

import lotto.enums.MatchingInfo;
import lotto.enums.PurchasingWay;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    void 로또리스트중_n개의숫자가_일치하는_로또카운팅_반환_테스트() {
        Lotto lotto1 = new Lotto(new LottoNumbers(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(45))));
        Lotto lotto2 = new Lotto(new LottoNumbers(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(16))));
        Lottos lottos = new Lottos(Arrays.asList(lotto1, lotto2));

        lottos.matchingWinningNumbersAndBonusNumber(new WinningLotto("1,2,3,4,5,6", 45));
        assertThat(lottos.countOfMatchingNumber(MatchingInfo.MATCH_FIVE_AND_BONUS)).isEqualTo(1);
        assertThat(lottos.countOfMatchingNumber(MatchingInfo.MATCH_FIVE)).isEqualTo(1);
    }

    @Test
    void 구입방식_로또_카운팅_반환_테스트() {
        Lotto lotto1 = new Lotto();
        Lotto lotto2 = new Lotto();
        Lotto lotto3 = new Lotto(new LottoNumbers(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(45))));
        Lotto lotto4 = new Lotto(new LottoNumbers(Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(16))));

        Lottos lottos = new Lottos(Arrays.asList(lotto1, lotto2, lotto3, lotto4));

        assertThat(lottos.countOfPurchasingWay(PurchasingWay.AUTOMATIC)).isEqualTo(2);
        assertThat(lottos.countOfPurchasingWay(PurchasingWay.MANUAL)).isEqualTo(2);
    }
}
