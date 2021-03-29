package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.machine.TestLottoGenerator;
import lotto.service.LottoService;
import lotto.view.dto.LottoOrderDto;
import lotto.view.dto.LottoOrderResultDto;
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

}
