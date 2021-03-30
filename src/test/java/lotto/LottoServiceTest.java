package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.machine.TestLottoGenerator;
import lotto.service.LottoScoring;
import lotto.service.LottoShopping;
import lotto.view.dto.LottoDto;
import lotto.view.dto.LottoOrderDto;
import lotto.view.dto.LottoOrderResultDto;
import lotto.view.dto.LottoScoringDto;
import lotto.view.dto.LottoScoringResultDto;
import lotto.view.dto.LottoWinnerDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    @Test
    @DisplayName("14000원을 입력하면 14장 로또를 발급하고 결과를 DTO로 반환한다.")
    void lottoOrderingServiceTest() {
        LottoShopping lottoService = new LottoShopping(new TestLottoGenerator());
        LottoOrderDto lottoOrderDto = new LottoOrderDto(14000);

        LottoOrderResultDto lottoOrderResultDto = lottoService.purchase(lottoOrderDto);

        assertThat(lottoOrderResultDto.getOrderedResult().size()).isEqualTo(14);
    }

    @Test
    @DisplayName("로또 14장을 구입하고 당첨금이 5000원일때, 당첨조건/당첨금/당첨횟수를 DTO로 반환한다.")
    void lottoWinnerScoringResultDtoTest() {
        LottoShopping lottoService = new LottoShopping(new TestLottoGenerator());
        LottoOrderDto lottoOrderDto = new LottoOrderDto(14000);
        LottoOrderResultDto lottoOrderResultDto = lottoService.purchase(lottoOrderDto);
        LottoDto winnerLottoDto = new LottoDto(17, 18, 19, 20, 21, 22);
        LottoScoringDto lottoScoringDto = new LottoScoringDto(winnerLottoDto, lottoOrderResultDto);

        LottoScoring lottoScoring = new LottoScoring();
        LottoScoringResultDto lottoScoringResultDto =
                lottoScoring.score(lottoScoringDto);
        LottoWinnerDto resultDto =
                lottoScoringResultDto.getWinnerDtoList()
                        .stream()
                        .filter(dto -> dto.getEqualNumberCount() == 3)
                        .findFirst()
                        .orElse(new LottoWinnerDto(0, 0, 0));

        assertThat(resultDto.toString()).isEqualTo("3개 일치 (5000)- 1개");
    }

    @Test
    @DisplayName("로또 14장을 구입하고 당첨금이 5000원일때, 수익률을 DTO로 반환한다.")
    void lottoWinnerEarningRateDtoTest() {
        LottoShopping lottoService = new LottoShopping(new TestLottoGenerator());
        LottoOrderDto lottoOrderDto = new LottoOrderDto(14000);
        LottoOrderResultDto lottoOrderResultDto = lottoService.purchase(lottoOrderDto);
        LottoDto winnerLottoDto = new LottoDto(17, 18, 19, 20, 21, 22);
        LottoScoringDto lottoScoringDto = new LottoScoringDto(winnerLottoDto, lottoOrderResultDto);

        LottoScoring lottoScoring = new LottoScoring();
        LottoScoringResultDto lottoScoringResultDto =
                lottoScoring.score(lottoScoringDto);

        assertThat(lottoScoringResultDto.getEarningRate()).isEqualTo("0.35");
    }
}
