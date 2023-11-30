package lotto;

import lotto.config.LottoFactory;
import lotto.controller.LottoController;
import lotto.dto.LottoMoneyDto;
import lotto.dto.LottosDto;

public class LottoMain {

    public static void main(String[] args) {
        LottoFactory lottoFactory = new LottoFactory();
        LottoController controller = lottoFactory.lottoController();
        runLottoGame(controller);
    }

    private static void runLottoGame(LottoController controller) {
        LottoMoneyDto lottoMoneyDto = controller.getLottoMoneyDto();
        long manualLottoCount = controller.getManualLottoCount(lottoMoneyDto);
        LottosDto lottosDto = controller.getLottosDto(manualLottoCount,
                lottoMoneyDto.getNumberOfAllLottos());
        controller.informLottoRankStatistics(lottosDto, lottoMoneyDto.getCost());
    }
}
