package step2;

import step2.controller.LottoController;
import step2.utils.AutoNumberGenerator;
import step2.utils.LottoNumberGenerator;
import step2.domain.PrizeMoney;
import step2.domain.ResultDto;
import step2.service.LottoService;

public class App {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        LottoNumberGenerator lottoNumberGenerator = new AutoNumberGenerator();
        PrizeMoney prizeMoney = new PrizeMoney();
        ResultDto resultDto = new ResultDto();

        LottoController lottoController = new LottoController(lottoService, lottoNumberGenerator, prizeMoney, resultDto);

        lottoController.buyLottoTicket();
        lottoController.inputWinningNumbers();
        lottoController.showResult();
    }
}
