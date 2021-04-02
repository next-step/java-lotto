package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.domain.machine.TestLottoGenerator;
import lotto.domain.shop.Money;
import lotto.dto.LottoOrderResultDto;
import lotto.dto.LottoScoreDto;
import lotto.dto.LottoScoreResultDto;
import lotto.service.LottoScoring;
import lotto.service.LottoShopping;
import lotto.view.ResultView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    @Test
    @DisplayName("14000원을 입력하면 14장 로또를 발급하고 결과를 DTO로 반환한다.")
    void lottoOrderingServiceTest() {
        LottoShopping lottoService = new LottoShopping(new TestLottoGenerator(0));
        Money money = new Money(14000);

        LottoOrderResultDto lottoOrderResultDto = lottoService.purchase(money);

        assertThat(lottoOrderResultDto.getOrderResult().size()).isEqualTo(14);
    }

    @Test
    @DisplayName("로또 14장을 구입하고 당첨금이 5000원일때, 당첨조건/당첨금/당첨횟수를 DTO로 반환한다.")
    void lottoWinnerScoringResultDtoTest() {
        LottoShopping lottoService = new LottoShopping(new TestLottoGenerator(0));
        Money money = new Money(14000);
        LottoOrderResultDto lottoOrderResultDto = lottoService.purchase(money);
        List<Integer> winnerLottoNumber = Arrays.asList(17, 18, 19, 20, 21, 22);
        Integer bonusNumber = 30;

        LottoScoring lottoScoring = new LottoScoring(lottoOrderResultDto, winnerLottoNumber, bonusNumber);
        LottoScoreResultDto lottoScoreResultDto = lottoScoring.getResult();
        LottoScoreDto resultDto =
                lottoScoreResultDto.getLottoScoreDtoList()
                        .stream()
                        .filter(dto -> dto.getMatchingBallCount() == 3)
                        .findFirst()
                        .orElse(new LottoScoreDto(0, 0, 0, 0));

        assertThat(resultDto.getMatchingBallCount()).isEqualTo(3L);
        assertThat(resultDto.getPrizeAmount()).isEqualTo(5000L);
        assertThat(resultDto.getWinners()).isEqualTo(1L);
    }

    @Test
    @DisplayName("로또 14장을 구입하고 당첨금이 5000원일때, 수익률을 DTO로 반환한다.")
    void lottoWinnerEarningRateDtoTest() {
        LottoShopping lottoService = new LottoShopping(new TestLottoGenerator(0));
        Money money = new Money(14000);
        LottoOrderResultDto lottoOrderResultDto = lottoService.purchase(money);
        List<Integer> winnerLottoNumber = Arrays.asList(17, 18, 19, 20, 21, 22);
        Integer bonusNumber = 30;

        LottoScoring lottoScoring = new LottoScoring(lottoOrderResultDto, winnerLottoNumber, bonusNumber);
        lottoScoring.getResult();

        assertThat(lottoScoring.getEarningRate()).isEqualTo("0.35");
    }
}
