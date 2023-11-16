package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StoreTest {
    @DisplayName("숫자를 로또 가격으로 나눈 몫을 리턴한다.")
    @Test
    void 판매가능_로또_갯수() {
        assertThat(Store.sellableLottoCount(14000)).isEqualTo(14000/Store.LOTTO_PRICE);
    }

    @DisplayName("금액만큼의 로또 리스트를 리턴한다.")
    @Test
    void 로또_자동_판매() {
        assertThat(Store.autoGamesSelling(14000).size()).isEqualTo(14);
    }
}