package lotto;

import lotto.LottoShop;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.domain.purchaseStrategy.AutoPurchaseStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoShopTest {

    LottoShop lottoShop;

    @BeforeEach
    void setUp() {
        lottoShop = new LottoShop();
    }

    @DisplayName("구입금액이 1000원 미만일때 예외 throw")
    @ParameterizedTest
    @ValueSource(ints = {999, 0, -1000})
    void validateAmount_구입가격이_1000원_미만(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lottoShop.buyLotto(input, new AutoPurchaseStrategy());
        }).withMessageMatching("최소 1000원 이상 지불하셔야 합니다.");
    }

    @DisplayName("로또용지가 넣은 돈만큼 나오는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"1700:1", "5600:5", "20000:20"}, delimiter = ':')
    void validateAmount_로또용지(int amount, int lottoCount) {
        assertThat(lottoShop.buyLotto(amount, new AutoPurchaseStrategy()).getLottos().size()).isEqualTo(lottoCount);
    }

    @DisplayName("번호 매칭 확인")
    @Test
    void checkLottoMatching_일치여부_확인() {
        WinningLotto winningLotto = new WinningLotto("5,15,20,35,40,45");
        List<Lotto> Lottolist = new ArrayList<>();
        Lottolist.add(new Lotto(Arrays.asList(5,15,20,35,40,45)));  // 6개일치
        Lottolist.add(new Lotto(Arrays.asList(5,15,20,35,40,42))); // 5개일치
        Lottolist.add(new Lotto(Arrays.asList(5,15,20,35,41,42))); // 4개일치
        Lottolist.add(new Lotto(Arrays.asList(11,12,23,35,40,45))); // 3개일치
        Lottolist.add(new Lotto(Arrays.asList(5,15,20,31,32,33))); // 3개일치
        Lottolist.add(new Lotto(Arrays.asList(5,15,30,31,32,33))); // 2개일치
        Lottolist.add(new Lotto(Arrays.asList(6,7,8,9,10,11))); // 0개일치
        Lottolist.add(new Lotto(Arrays.asList(21,22,23,24,25,26))); // 0개일치
        Lottolist.add(new Lotto(Arrays.asList(36,37,38,39,41,42))); // 0개일치

        Map<Rank, Integer> map = lottoShop.checkLottoMatching(winningLotto, new Lottos(Lottolist));

        assertThat(map.get(Rank.FIRST)).isEqualTo(1); // 6개일치
        assertThat(map.get(Rank.SECOND)).isEqualTo(1); // 5개일치
        assertThat(map.get(Rank.THIRD)).isEqualTo(1); // 4개일치
        assertThat(map.get(Rank.FOURTH)).isEqualTo(2); // 3개일치
        assertThat(map.get(Rank.MISS)).isEqualTo(3); // 0개일치
    }

}
