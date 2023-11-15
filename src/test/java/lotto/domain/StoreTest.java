package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class StoreTest {
    @DisplayName("숫자를 로또 가격으로 나눈 몫을 리턴한다.")
    @Test
    void 구매가능_로또_갯수() {
        assertThat(Store.purchasableLottoCount(14000)).isEqualTo(14000/Store.LOTTO_PRICE);
    }
}