package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoStoreTest {

    @Test
    void testIssue(){
        int amount = 14000;
        List<Lotto> lottoList = LottoStore.issue(String.valueOf(amount));

        Assertions.assertThat(lottoList)
                .hasSize(amount/LottoStore.LOTTO_PRICE);
    }
}
