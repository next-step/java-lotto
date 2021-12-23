package lotto;

import lotto.lotto.Lotto;
import lotto.lotto.Lottos;
import lotto.lotto.lottonumber.LottoNumber;
import lotto.lotto.lottonumber.LottoNumbers;
import lotto.result.LottoResults;
import lotto.result.Rank;
import lotto.result.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    @DisplayName("Lottos 객체를 생성한다")
    void shouldCreateSameObject() {
        Lottos lottos = lottos();
        assertThat(lottos).isEqualTo(lottos());
    }

    @Test
    @DisplayName("구매한 금액만큼 Lottos 객체를 생성한다")
    void shouldCreateWithPurchaseAmount() {
        Lottos lottos = Lottos.from(10000);
        assertThat(lottos.values().size()).isEqualTo(10);
    }

    @Test
    @DisplayName("로또 당첨 결과를 구한다")
    void shouldReturnCount() {
        Lottos lottos = lottos();
        WinningNumbers winningNumbers = winningNumbers();
        int purchaseAmount = 3000;

        LottoResults result = lottos.result(winningNumbers, purchaseAmount);

        assertThat(result.matchedLottoNumbersCount(Rank.SECOND)).isEqualTo(2L);
        assertThat(result.matchedLottoNumbersCount(Rank.FIFTH)).isEqualTo(1L);
    }

    @Test
    @DisplayName("수동으로 로또를 발급한다")
    void shouldCreateIncludingManualLottos() {
        int purchaseAmount = 3000;
        String input1 = "8, 21, 23, 41, 42, 43";
        String input2 = "3, 5, 11, 16, 32, 38";

        Lottos manualLottos = Lottos.from(new String[]{input1, input2});
        Lottos totalLottos = Lottos.of(purchaseAmount, manualLottos);

        assertThat(totalLottos.values().size()).isEqualTo(3);
        assertThat(totalLottos.values()).contains(Lotto.from(input1));
        assertThat(totalLottos.values()).contains(Lotto.from(input2));
    }

    private Lottos lottos() {
        return Lottos.from(new String[]{
                "1, 2, 3, 7, 8, 9",
                "1, 2, 3, 7, 8, 10",
                "1, 2, 3, 4, 7, 8"
        });
    }

    private WinningNumbers winningNumbers() {
        return WinningNumbers.of(LottoNumbers.from("1, 2, 3, 4, 5, 10"), LottoNumber.from("7"));
    }
}