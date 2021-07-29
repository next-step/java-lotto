package lotto.service;

import lotto.domain.lotto.LottoPackage;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.money.Money;
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

import static lotto.fixture.LottoFixture.getLottos;
import static lotto.fixture.LottoFixture.getWinningLotto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {
    @DisplayName("Money가 1000원 이상일때 LottoService purchase를 통해 LottoPackage를 구할 수 있다")
    @CsvSource(value = {"1000^1", "10000^10"}, delimiter = '^')
    @ParameterizedTest
    public void shoud_return_lottopackage(int money, int expectedCount) throws Exception {
        //arrange, act
        LottoPackage lottoPackage = LottoService.purchase(Money.of(money));

        //assert
        assertThat(lottoPackage.getLottos().size()).isEqualTo(expectedCount);
    }

    @DisplayName("구매한 LottoPackage와 WinningLotto를 LottoService의 match를 통해 match결과를 받을 수 있다")
    @Test
    public void shoud_return_matchResult() throws Exception {
        //arrange
        LottoPackage lottoPackage = LottoPackage.of(getLottos(), Money.of(2000));
        WinningLotto winningLotto = getWinningLotto();
        Set<LottoPrize> expectedLottoPrize = new HashSet<>(Arrays.asList(LottoPrize.FOURTH, LottoPrize.FIRST));
        List<Long> expectedCount = Arrays.asList(1L, 1L);

        //act
        MatchResult matchResult = LottoService.match(lottoPackage, winningLotto);

        //assert
        assertAll(
                () -> assertThat(matchResult.getMatchResult().keySet()).containsAll(expectedLottoPrize),
                () -> assertThat(matchResult.getMatchResult().values()).containsAll(expectedCount)
        );
    }
}