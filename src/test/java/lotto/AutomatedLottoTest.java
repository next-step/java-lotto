package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoShop;
import lotto.domain.Money;
import lotto.domain.policy.TestRandomPolicy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * 로또(자동)
 *
 * [ 기능 구현 목록 ]
 * 1. LottoMachine은 1~45까지 범위에서 숫자 6개를 뽑아낸다.
 *    - 추첨 정책은 인터페이스를 활용하여 갈아 끼울 수 있도록 한다.
 *
 * 2. 로또 구입 금액을 입력하면, 구입 금액에 해당하는 만큼의 로또를 발급한다.
 *    - 로또 1장당 금액은 1,000원이다.
 *
 * 3. 당첨 번호를 입력하면, 일치하는 번호 개수당 순위를 매긴다.
 *     - 1등은 6개 일치, 2등은 5개 일치, 3등은 4개 일치, 4등은 3개 일치.
 *
 * 4. 로또 구입액과 당첨 금액으로 수익률을 계산한다.
 * */
public class AutomatedLottoTest {

    @Test
    @DisplayName("로또 1장을 발급한다.")
    void lottoCreateTest() {
        LottoMachine lottoMachine = new LottoMachine(new TestRandomPolicy());

        Lotto lotto = lottoMachine.generate();

        assertThat(lotto).isEqualTo(new Lotto(10, 13, 44, 17, 20, 33));
    }

    @ParameterizedTest
    @CsvSource(value = {"1200:1", "3800:3", "8800:8", "0:0", "100:0"}, delimiter = ':')
    @DisplayName("로또 구입 금액에 해당하는 만큼의 로또를 발급한다.")
    void lottoCreateByPriceTotal(int money, int lottoCount) {
        LottoMachine lottoMachine = new LottoMachine(new TestRandomPolicy());
        LottoShop lottoShop = new LottoShop(lottoMachine);

        List<Lotto> lotteries = lottoShop.purchase(new Money(money));

        assertThat(lotteries.size()).isEqualTo(lottoCount);
    }
}
