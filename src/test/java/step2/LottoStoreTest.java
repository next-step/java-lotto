package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.LottoStore;

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

        assertThatThrownBy(() -> lottoStore.initWinNumbers(""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> lottoStore.initWinNumbers("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자가 아닌 값이나 로또 범위를 초과하는 값을 입력할 경우 Exception이 발생한다.")
    void initWinNumbes_isNotNumberAndisNotLottoNumber_Exception() {
        LottoStore lottoStore = new LottoStore();

        assertThatThrownBy(() -> lottoStore.initWinNumbers("a,b,1,2,3,4"))
                .isInstanceOf(RuntimeException.class);

        assertThatThrownBy(() -> lottoStore.initWinNumbers("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> lottoStore.initWinNumbers("0,2,3,4,5,45"))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("우승 숫자를 입력하면 Integer 리스트로 저장한다.")
    void initWinNumbers() {
        LottoStore lottoStore = new LottoStore();
        lottoStore.initWinNumbers("1,2,3,4,5,6");
        assertThat(lottoStore.getWinNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("당첨된 로또의 상금을 반환함.")
    void findWinLottoMoney() {
        LottoStore lottoStore = new LottoStore();
        lottoStore.buy(100000);
        lottoStore.initWinNumbers("2,5,10,15,20,25");

        List<Long> winLottoMoney = lottoStore.findWinLottoMoney();

        for (Long money : winLottoMoney) {
            System.out.println(money);
        }
    }
}
