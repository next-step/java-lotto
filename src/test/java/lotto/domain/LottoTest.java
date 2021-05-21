package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoTest {

    @Test
    void 로또와_당첨번호_비교_Test() {
        LottoWinNumbers winNumbers = new LottoWinNumbers("1, 2, 3, 4, 5, 6");
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lotto.matchCountOf(winNumbers).result()).isEqualTo(6);
    }

    @DisplayName("랜덤으로 1~ 45 사이의 중복없는 번호들 생성")
    @Test
    void 구매_로또_번호생성_Test() {
        Lotto lotto = new Lotto();
        String[] nums = lotto.toString().substring(1, lotto.toString().length()-2).split(", ");
        for (int i = 0; i < nums.length; ++i) {
            assertThat(Integer.parseInt(nums[i])).isGreaterThanOrEqualTo(1);
            assertThat(Integer.parseInt(nums[i])).isLessThanOrEqualTo(45);
        }
    }

    @Test
    void 입력된_유효하지않은_당첨번호_Test() {
        assertThatThrownBy(() -> new LottoWinNumbers("1, 2, 3, 4, 5, b"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoWinNumbers("1, 2, 3, 4, 5"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoWinNumbers("1, 2, 3, 4, 5, 6, 7"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoWinNumbers("1, 2, 59, 4, 5, 5"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoWinNumbers("1, 2, 3, -1, 5, 6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매개수만큼_로또_생성_Test() {
        LottoPurchaseBudget budget = new  LottoPurchaseBudget(5000);
        LottoGame game = new LottoGame();
        Lottos lottos = game.buyLottos(budget.countOfAvailableLotto());

        assertThat(lottos.count()).isEqualTo(5);
    }

    @Test
    void 유효한_로또구매금액_Test() {
        LottoPurchaseBudget budget = new  LottoPurchaseBudget(1000);
        assertThat(budget.equals(new LottoPurchaseBudget(1000)));
    }

    @Test
    void 유효하지않은_로또구매금액_Test() {
        assertThatThrownBy(() -> new LottoPurchaseBudget(999))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoPurchaseBudget(900))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
