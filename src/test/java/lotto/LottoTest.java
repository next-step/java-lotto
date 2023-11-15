package lotto;

import lotto.model.Lotto;
import lotto.model.BuyLotto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    @Test
    void 구입금액을_1000으로_나눈_몫은_구입개수() throws Exception {
        //given
        int amount = 1250;
        BuyLotto buyLotto = new BuyLotto(amount);
        //then
        assertThat(buyLotto.purchaseCount()).isEqualTo(1);
    }

    @Test
    void 당첨번호_정확히_6개가_아니면에러() throws Exception {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 생성된_로또는_오름차순정렬() throws Exception {
        //given
        List<Integer> numbers = new ArrayList<>(List.of(6, 5, 4, 3, 2, 1));
        Lotto lotto = new Lotto(numbers);
        //then
        assertThat(lotto.lottoNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

}
