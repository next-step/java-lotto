package Lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

class LottoNumberCreateMachineTest {

    static final int WANTED_LOTTO_COUNT = 6;
    private static final int LOTTO_PRICE = 1000;
    private static final int MANUAL_LOTTO_COUNT = 0;

    @Test
    @DisplayName("로또가 천원일 때 가격만큼 사는지 확인")
    public void buyLottoTest() {
        LottoNumberCreateMachine lottoNumberCreateMachine = new LottoNumberCreateMachine();
        LottoBuyResource lottoBuyResource = new LottoBuyResource(WANTED_LOTTO_COUNT * LOTTO_PRICE, MANUAL_LOTTO_COUNT);
        Lottos lottos = lottoNumberCreateMachine.createLottos(lottoBuyResource, new Lottos(new ArrayList<Lotto>()));
        int lottoCount = lottos.getLottos().size();
        assertThat(lottoCount).isEqualTo(WANTED_LOTTO_COUNT);
    }

}