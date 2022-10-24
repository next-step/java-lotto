package lotto;

import exception.CustomException;
import lotto.exception.LottoErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoStatisticalServiceTest {

    @Test
    @DisplayName("당첨 번호를 통해 로또 통계 서비스를 생성한다")
    void createLottoStatisticalService() {
        LottoStatisticalService lottoStatisticalService =
                new LottoStatisticalService(Lotto.from("1, 2, 3, 4, 5, 6"));
        assertThat(lottoStatisticalService).isNotNull();
    }

    @Test
    @DisplayName("중복된 글자가 포함 시 당첨 번호가 생성되지 않는다")
    void createLottoStatisticalServiceFail() {
        assertThatThrownBy(() ->
                new LottoStatisticalService(Lotto.from("1, 2, 2, 3, 4, 5")))
                .isInstanceOf(CustomException.class)
                .hasMessage(LottoErrorCode.LOTTO_NUMBER_OVERLAP.getMessage());
    }

    @Test
    @DisplayName("당첨 로또와 구매한 로또를 비교해 당첨 통계 결과값을 반환한다")
    void giveStatistics() {
        List<Lotto> purchasedLotto = new ArrayList<>();
        Lotto winningLotto = Lotto.generate();
        purchasedLotto.add(winningLotto);

        LottoStatisticalService lottoStatisticalService = new LottoStatisticalService(winningLotto);
        Map<MatchNumberAndPrize, Integer> matchNumberAndPrizeIntegerMap =
                lottoStatisticalService.giveStatistics(purchasedLotto);

        Integer result = matchNumberAndPrizeIntegerMap.get(MatchNumberAndPrize.FIRST);

        assertThat(result).isOne();
    }

    @Test
    @DisplayName("수익률을 계산한다")
    void calculateYield() {
        int paymentAmount = 14000;
        Long winningAmount = 5000L;

        LottoStatisticalService lottoStatisticalService = new LottoStatisticalService(Lotto.generate());
        float result = lottoStatisticalService.calculateYield(paymentAmount, winningAmount);

        assertThat(result).isEqualTo((float) winningAmount / paymentAmount);
    }
}
