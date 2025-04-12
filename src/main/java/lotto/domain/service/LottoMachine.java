package lotto.domain.service;

import lotto.domain.generator.LottoTicketGenerator;
import lotto.domain.model.LottoRequest;
import lotto.domain.model.LottoTicket;
import lotto.domain.model.LottoWallet;
import lotto.domain.model.LottoNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    public static LottoWallet buy(LottoTicketGenerator lottoTicketGenerator, LottoRequest request) {
        LottoWallet lottoWallet = new LottoWallet();
        lottoWallet.addLottos(buyManualLottos(request));
        lottoWallet.addLottos(buyAutomaticLottos(request.getAutomaticLottosCount(), lottoTicketGenerator));
        return lottoWallet;
    }

    private static List<LottoTicket> buyManualLottos(LottoRequest request) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (List<Integer> manualNumbers : request.getManualNumbersList()) {
            LottoTicket lotto = new LottoTicket(manualNumbers.stream().map(LottoNumber::new).collect(Collectors.toList()));
            lottoTickets.add(lotto);
        }
        return lottoTickets;
    }

    private static List<LottoTicket> buyAutomaticLottos(int numLottos, LottoTicketGenerator lottoTicketGenerator) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < numLottos; i++) {
            LottoTicket lotto = lottoTicketGenerator.generate();
            lottoTickets.add(lotto);
        }
        return lottoTickets;
    }
}
