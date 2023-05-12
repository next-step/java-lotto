package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoStoreTest {
    @Test
    @DisplayName("로또 갯수 테스트")
    void lottoCount() {
        //given
        int buyAmount = 14000;

        // when
        LottoStore lottoStore = new LottoStore();
        List<Lotto> lottoList = lottoStore.buy(buyAmount);

        //then
        int expected = 14;

        assertEquals(expected, lottoList.size());

    }
}
