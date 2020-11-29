package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lotto;
import step2.domain.LottoStore;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoStoreTest {

    @Test
    @DisplayName("천원보다 낮은 금액을 입력한 경우 IllegalArgumentException 발생함..")
    void buyLotto_isNotEnoughFee_IllegalArgumentException() {
        LottoStore lottoStore = new LottoStore();
        assertThatThrownBy(() -> lottoStore.buy(990))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 구매를 요청한 경우 천원당 하나의 로또를 반환함.")
    void buyLotto() {
        LottoStore lottoStore = new LottoStore();
        assertThat(lottoStore.buy(1000).size()).isEqualTo(1);
        assertThat(lottoStore.buy(3000).size()).isEqualTo(3);
    }

    @Test
    @DisplayName("공백이나 6자리가 안되는 숫자를 입력하면 IllegalArgumentException 발생함.")
    void initWinNumbers_isBlankAndisNotMatchNumberCount_IllegalArgumentException() {
        LottoStore lottoStore = new LottoStore();

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(6);

        assertThatThrownBy(() -> lottoStore.initWinNumbers(list))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자가 아닌 값이나 로또 범위를 초과하는 값을 입력할 경우 Exception이 발생한다.")
    void initWinNumbes_isNotNumberAndisNotLottoNumber_Exception() {
        LottoStore lottoStore = new LottoStore();

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(0);
        list.add(46);

        assertThatThrownBy(() -> lottoStore.initWinNumbers(list))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("우승 숫자를 입력하면 Integer 리스트로 저장한다.")
    void initWinNumbers() {
        LottoStore lottoStore = new LottoStore();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(44);
        list.add(45);

        lottoStore.initWinNumbers(list);
        assertThat(lottoStore.getWinNumbers().size()).isEqualTo(6);
    }
}
