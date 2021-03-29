package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.machine.LottoMachine;
import lotto.domain.machine.TestLottoGenerator;
import lotto.domain.prize.Prize;
import lotto.domain.shop.LottoShop;
import lotto.domain.stats.LottoEarningRateCalculator;

import lotto.domain.stats.LottoScoreBoard;
import lotto.view.dto.LottoDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * [ 기능 구현 목록 ]
 * 1. LottoMachine은 1~45까지 범위에서 숫자 6개를 Lotto 객체를 만든다.
 *     - 추첨 정책은 인터페이스를 활용하여 갈아 끼울 수 있도록 한다.
 *
 * 2. 로또 구입 금액을 입력하면, 구입 금액에 해당하는 만큼의 로또를 발급한다.
 *     - 로또 1장당 금액은 1,000원이다.
 *
 * 3. Lotto 객체 간에 서로 번호를 비교하여, 일치하는 번호 개수를 반환할 수 있도록 한다.
 *
 * 4. 일치하는 번호 개수에 해당하는 Prize를 반환할 수 있도록 한다.
 *
 * 5. 당첨 번호를 입력하면, 일치하는 번호 개수에 따라 Prize를 매긴다.
 *     - 6개면 Prize.FIRST, 5개면 Prize.SECOND, 4개면 Prize.THIRD, 3개면 Prize.FOURTH.
 *
 * 6. 총 로또 구입액과 당첨 금액으로 수익률을 계산한다.
 */
public class AutomatedLottoTest {

    @Test
    @DisplayName("1~45까지 범위에서 숫자 6개를 가진 Lotto 객체를 만든다.")
    void lottoCreateTest() {
        LottoMachine lottoMachine = new LottoMachine(new TestLottoGenerator());

        Lotto lotto = lottoMachine.generate();

        assertThat(lotto).isEqualTo(new Lotto(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("번호가 6자리가 아니면, 예외를 발생시킨다.")
    void lottoWrongNumberFormatTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(1, 2, 3))
                .withMessage("로또는 6개 숫자여야 합니다.");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(1, 2, 3, 4, 5))
                .withMessage("로또는 6개 숫자여야 합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1200:1", "3800:3", "8800:8", "0:0", "100:0", "16000:16"}, delimiter = ':')
    @DisplayName("구입 금액을 입력하면, 금액에 해당하는 만큼 로또를 발급한다.")
    void lottoPurchaseTest(long money, long lottoQuantity) {
        LottoShop lottoShop = new LottoShop(money, new TestLottoGenerator());

        List<Lotto> lottories = lottoShop.purchase();

        assertThat(lottories.size()).isEqualTo(lottoQuantity);
    }

    @Test
    @DisplayName("구입 금액이 음수이면, 예외를 발생시킨다.")
    void lottoShopNegativeBalanceTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoShop(-3000, new TestLottoGenerator()))
                .withMessage("금액은 음수일 수 없습니다.");
    }

    @Test
    @DisplayName("로또 객체 간에 숫자를 비교하여, 일치하는 개수를 반환한다.")
    void lottoComparingTest() {
        Lotto myLotto = new Lotto(3, 6, 9, 12, 15, 18);
        Lotto yourLotto = new Lotto(2, 4, 6, 8, 10, 12);

        long counts = myLotto.getEqualNumberCountFrom(yourLotto);

        assertThat(counts).isEqualTo(2L);
    }

    @ParameterizedTest
    @CsvSource(value = {"6:2000000000", "5:1500000", "4:50000", "3:5000"}, delimiter = ':')
    @DisplayName("일치하는 개수에 따라 Prize(당첨금)을 반환한다.")
    void lottoPrizeMappingTest(long number, long expectedPrize) {
        long prize = Prize.getPrizeByEqualNumberCount(number);

        assertThat(prize).isEqualTo(expectedPrize);
    }

    @Test
    @DisplayName("로또 14개를 구입했을 때, 당첨금이 5000원인 경우 수익률을 계산한다.")
    void lottoEarningRateCalcuateTest() {
        LottoShop lottoShop = new LottoShop(14000, new TestLottoGenerator());
        Lotto winnerLotto = new Lotto(17, 18, 19, 20, 21, 22);
        List<Lotto> lotteries = lottoShop.purchase();
        LottoScoreBoard lottoScoreBoard = new LottoScoreBoard(winnerLotto, lotteries);
        final long balance = lotteries.size() * 1000;
        LottoEarningRateCalculator calculator = new LottoEarningRateCalculator(balance, lottoScoreBoard);

        String earningRate = calculator.resultToString();

        assertThat(earningRate).isEqualTo("0.35");
    }

}
