package lotto.service;

import lotto.domain.lotto.*;
import lotto.domain.money.Money;
import lotto.domain.money.PaymentInfo;
import lotto.domain.prize.LottoPrize;
import lotto.domain.prize.MatchResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.fixture.LottoFixture.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {
    @DisplayName("수동로또가 없고 Money가 1000원 이상일때 LottoService purchase를 통해 LottoPackage를 구할 수 있다")
    @CsvSource(value = {"1000^1", "10000^10"}, delimiter = '^')
    @ParameterizedTest
    public void shoud_return_lottopackage(int moneyAmount, int expectedCount) throws Exception {
        //arrange
        Money money = Money.of(moneyAmount);
        Lottos manualLottos = null;
        PaymentInfo paymentInfo = PaymentInfo.of(money, manualLottos);

        Lottos lottos = LottoService.purchase(paymentInfo, manualLottos);

        //assert
        assertThat(lottos.size()).isEqualTo(expectedCount);
    }

    @DisplayName("Money가 2000원 일때 수동 로또 + 자동 로또 합쳐서 2개가 구매된다")
    @Test
    public void shoud_return_lottopackage_with_manual_lotto() throws Exception {
        //arrange
        Money money = Money.of(2000);
        Lottos manualLottos = getOneManaualLottos();
        PaymentInfo paymentInfo = PaymentInfo.of(money, manualLottos);

        //act
        Lottos resultLottos = LottoOffice.purchase(paymentInfo, manualLottos);

        //assert
        assertThat(resultLottos.size()).isEqualTo(2);
    }

    @DisplayName("구매한 LottoPackage와 WinningLotto를 LottoService의 match를 통해 match결과를 받을 수 있다")
    @Test
    public void shoud_return_matchResult() throws Exception {
        //arrange
        Lottos lottos = getLottos();
        Money money = Money.of(2000);
        WinningLotto winningLotto = getWinningLotto();
        Set<LottoPrize> expectedLottoPrize = new HashSet<>(Arrays.asList(LottoPrize.FOURTH, LottoPrize.FIRST));
        List<Long> expectedCount = Arrays.asList(1L, 1L);

        //act
        MatchResult matchResult = LottoService.match(lottos, money, winningLotto);

        //assert
        assertAll(
                () -> assertThat(matchResult.getMatchResult().keySet()).containsAll(expectedLottoPrize),
                () -> assertThat(matchResult.getMatchResult().values()).containsAll(expectedCount)
        );
    }
}