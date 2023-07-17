package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

import java.util.List;
import lotto.domain.game.LottoCount;
import lotto.domain.game.Lottos;
import lotto.domain.game.NumberGenerator;
import lotto.domain.game.Payment;
import lotto.domain.game.WinningNumber;
import lotto.domain.statistics.LottoStatistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStatisticsTest {

    @DisplayName("로또 결과 통계 객체 생성 성공")
    @Test
    void create() {
        int inputMoney = 3000;
        Payment payment = new Payment(inputMoney);

        int lottoManualCount = 2;
        List<String> lottosManual = List.of(
            "1,2,3,4,5,6",
            "7,8,9,10,11,12"
        );
        LottoCount lottoCount = new LottoCount(payment, lottoManualCount);
        NumberGenerator numberGenerator = () -> List.of(1,2,3,4,5,6);
        Lottos lottos = new Lottos(lottoCount, lottosManual, numberGenerator);

        String lottoValue = "1,2,3,4,5,6";
        int bonusValue = 7;
        WinningNumber winningNumber = new WinningNumber(lottoValue, bonusValue);

        assertThatNoException().isThrownBy(() -> new LottoStatistics(lottos, winningNumber, payment));
    }

    @DisplayName("로또 수익률 반환")
    @Test
    void getProfitRate() {
        int inputMoney = 3000;
        Payment payment = new Payment(inputMoney);

        int lottoManualCount = 2;
        List<String> lottosManual = List.of(
            "1,2,3,4,5,6",
            "7,8,9,10,11,12"
        );
        LottoCount lottoCount = new LottoCount(payment, lottoManualCount);
        NumberGenerator numberGenerator = () -> List.of(40,41,42,43,44,45);

        Lottos lottos = new Lottos(lottoCount, lottosManual, numberGenerator);

        String lottoValue = "1,2,3,4,5,8";
        int bonusValue = 7;
        WinningNumber winningNumber = new WinningNumber(lottoValue, bonusValue);

        LottoStatistics lottoStatistics = new LottoStatistics(lottos, winningNumber, payment);
        assertThat(lottoStatistics.getProfitRate()).isEqualTo(500.00);
    }

}
