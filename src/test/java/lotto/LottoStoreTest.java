package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoStoreTest {

    @DisplayName("로또스토어는 구매 금액만큼 로또를 발행한다.")
    @Test
    void testIssue(){
        int amount = 14000;
        List<Lotto> lottoList = LottoStore.issue(String.valueOf(amount));

        Assertions.assertThat(lottoList)
                .hasSize(amount/LottoStore.LOTTO_PRICE);
    }
}
