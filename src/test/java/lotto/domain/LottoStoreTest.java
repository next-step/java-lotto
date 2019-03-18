package lotto.domain;

import lotto.domain.lotto.BasicLotto;
import lotto.utils.RandomLottoGenerator;
import lotto.utils.TestLottoGenerator;
import lotto.view.InputView;
import org.junit.Test;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStoreTest {

    @Test(expected = IllegalArgumentException.class)
    public void 구입금액_음수입력시_예외() {
        Scanner scanner = new Scanner("-1000");
        int money = InputView.getMoney("구입금액을 입력하세요.", scanner);
        LottoStore lottoStore = new LottoStore(new RandomLottoGenerator());
        lottoStore.buyLottos(money);
    }

    @Test
    public void 횟수만큼_로또_생성() {
        Scanner scanner = new Scanner("10000");
        int money = InputView.getMoney("구입금액을 입력하세요.", scanner);
        LottoStore lottoStore = new LottoStore(new RandomLottoGenerator());

        assertThat(lottoStore.buyLottos(money).size()).isEqualTo(10);
    }

    @Test
    public void 테스트전용_로또생성기로_로또생성() {
        Scanner scanner = new Scanner("10000");
        int money = InputView.getMoney("구입금액을 입력하세요.", scanner);
        LottoStore lottoStore = new LottoStore(new TestLottoGenerator());

        BasicLotto firstLotto = lottoStore.buyLottos(money).get(0);

        assertThat(firstLotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
