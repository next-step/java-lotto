package lottogame.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lottogame.controller.spi.Inputer;
import lottogame.controller.spi.Viewer;
import lottogame.domain.LottoCheckManager;
import lottogame.domain.LottoPurchaseManager;
import lottogame.domain.dto.LottoTicketDto;
import lottogame.domain.response.LottoCheckedResponse;
import lottogame.domain.spi.NumberGenerator;

public class LottoController {

    private final Inputer inputer;
    private final Viewer viewer;
    private final LottoPurchaseManager lottoPurchaseManager;

    public LottoController(Inputer purchaseInputer, Viewer purchaseViewer, NumberGenerator numberGenerator) {
        this.inputer = purchaseInputer;
        this.viewer = purchaseViewer;
        this.lottoPurchaseManager = new LottoPurchaseManager(numberGenerator);
    }

    public void run() {
        List<LottoTicketDto> lottoTicketDtos = purchaseLottoTickets();
        checkResult(lottoTicketDtos);
    }

    private List<LottoTicketDto> purchaseLottoTickets() {
        BigInteger money = inputer.inputMoney();
        int passiveLottoTicketCount = inputer.inputPassiveLottoTicketCount();
        List<LottoTicketDto> selectedLottoTickets = toLottoTicketDtos(
            inputer.inputPassiveLottoTickets(passiveLottoTicketCount));
        List<LottoTicketDto> lottoTicketDtos = lottoPurchaseManager.purchase(money, selectedLottoTickets);

        viewer.drawLottoPurchasedResponses(passiveLottoTicketCount, lottoTicketDtos);

        return lottoTicketDtos;
    }

    private List<LottoTicketDto> toLottoTicketDtos(List<Set<Integer>> passiveLottoTicketNumbers) {
        return passiveLottoTicketNumbers.stream()
            .map(LottoTicketDto::new)
            .collect(Collectors.toList());
    }

    private void checkResult(List<LottoTicketDto> lottoTicketDtos) {
        Set<Integer> lottoResultNumbers = inputer.inputWinningLottoNumbers();
        Integer bonusNumber = inputer.inputBonusLottoNumber();
        LottoCheckManager lottoCheckManager = new LottoCheckManager(lottoResultNumbers, bonusNumber);
        LottoCheckedResponse lottoCheckedResponse = lottoCheckManager.checkResult(lottoTicketDtos);

        viewer.drawLottoCheckedResponse(lottoCheckedResponse);
    }

}
