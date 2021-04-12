package step2;

import step2.controller.LottoController;
import step2.utils.AutoNumberGenerator;
import step2.utils.LottoNumberGenerator;
import step2.domain.PrizeMoney;
import step2.domain.ResultDto;
import step2.service.LottoService;

public class App {
    public static void main(String[] args) {
        PrizeMoney prizeMoney = new PrizeMoney();
        ResultDto resultDto = new ResultDto();
        LottoService lottoService = new LottoService(resultDto);
        LottoNumberGenerator lottoNumberGenerator = new AutoNumberGenerator();

        LottoController lottoController = new LottoController(lottoService, lottoNumberGenerator, prizeMoney, resultDto);

        lottoController.buyLottoTicket();
        lottoController.printPurchaseHistory();
        lottoController.inputWinningNumbers();
        lottoController.showResult();
    }
}
