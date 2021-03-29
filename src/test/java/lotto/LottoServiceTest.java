package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.machine.TestLottoGenerator;
import lotto.service.LottoScoringService;
import lotto.service.LottoService;
import lotto.view.dto.LottoDto;
import lotto.view.dto.LottoOrderDto;
import lotto.view.dto.LottoOrderResultDto;
import lotto.view.dto.LottoScoringDto;
import lotto.view.dto.LottoScoringResultDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    @Test
    @DisplayName("구입 금액에 따라 로또를 구매하는 서비스")
    void lottoOrderingServiceTest() {
        LottoService lottoService = new LottoService(new TestLottoGenerator());
        LottoOrderDto lottoOrderDto = new LottoOrderDto(14000);

        LottoOrderResultDto lottoOrderResultDto = lottoService.purchase(lottoOrderDto);

        assertThat(lottoOrderResultDto.getOrderedResult().size()).isEqualTo(14);
    }

    @Test
    @DisplayName("당첨 번호를 입력하면, 구매한 로또와 비교해주는 서비스")
    void lottoWinnerScoringServiceTest() {
        LottoService lottoService = new LottoService(new TestLottoGenerator());
        LottoOrderDto lottoOrderDto = new LottoOrderDto(14000);
        LottoOrderResultDto lottoOrderResultDto = lottoService.purchase(lottoOrderDto);
        LottoDto winnerLottoDto = new LottoDto(17, 18, 19, 20, 21, 22);
        LottoScoringDto lottoScoringDto = new LottoScoringDto(winnerLottoDto, lottoOrderResultDto);

        LottoScoringService lottoScoringService = new LottoScoringService();
        LottoScoringResultDto lottoScoringResultDto = lottoScoringService.score(lottoScoringDto);

        assertThat(lottoScoringResultDto.getEarningRate()).isEqualTo("0.35");
    }
}
