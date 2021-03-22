package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoConstant;
import lotto.domain.LottoMachine;
import lotto.domain.LottoShop;
import lotto.domain.Money;
import lotto.domain.policy.TestRandomPolicy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.ArgumentsSources;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    @CsvSource(value = {"1200:1", "3800:3", "8800:8", "0:0", "100:0", "16000:16"}, delimiter = ':')
    @DisplayName("로또 구입 금액에 해당하는 만큼의 로또를 발급한다.")
    void lottoCreateByPriceTotal(int money, int lottoCount) {
        LottoMachine lottoMachine = new LottoMachine(new TestRandomPolicy());
        LottoShop lottoShop = new LottoShop(lottoMachine);

        List<Lotto> lotteries = lottoShop.purchase(new Money(money));

        System.out.println(lotteries);
        assertThat(lotteries.size()).isEqualTo(lottoCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"10:13:44:17:20:33:6", "10:13:44:17:20:23:5",
            "1:23:44:17:20:33:4", "10:3:2:17:20:8:3", "1:13:2:17:4:5:2",
            "10:9:8:7:6:5:1", "1:2:3:4:5:6:0"}, delimiter = ':')
    @DisplayName("당첨된 번호 개수가 맞은지 확인하기")
    void lottoCountWinnerNumber(int n1, int n2, int n3, int n4, int n5, int n6, long expectedCount) {
        LottoMachine lottoMachine = new LottoMachine(new TestRandomPolicy());

        Lotto lotto = lottoMachine.generate();
        long result = lotto.countWinnerNumbersIn(new Lotto(n1, n2, n3, n4, n5, n6));

        assertThat(result).isEqualTo(expectedCount);
    }
}
