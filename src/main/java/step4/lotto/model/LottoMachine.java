package step4.lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import step4.lotto.exception.LottoMachineException;
import step4.lotto.exception.LottoMachineNotEnoughMoneyException;
import step4.lotto.view.InputView;

public class LottoMachine {

    public final static Money PRICE = new Money(1000);
    private final List<LottoNumber> allLottoNumbers;
    private final static InputView inputView = new InputView();

    public LottoMachine() {
        allLottoNumbers = new ArrayList<>();
        for (int i = LottoNumber.MIN_VALUE; i <= LottoNumber.MAX_VALUE; i++) {
            allLottoNumbers.add(new LottoNumber(i));
        }
    }

    public LottoTicketList buyLottoTickets(Money purchaseAmount, Count manualLottoTicketCount) {
        validateBuyLottoTickets(purchaseAmount, manualLottoTicketCount);
        List<LottoTicket> lottoTickets = new ArrayList<>();
        inputView.printManualLottoNumbersTitle();
        for (int i = 0; i < manualLottoTicketCount.value(); i++) {
            lottoTickets.add(issueLottoTicketManual());
            purchaseAmount.subtract(PRICE);
        }
        Count ticketCount = new Count(purchaseAmount.value() / PRICE.value());
        for (int i = 0; i < ticketCount.value(); i++) {
            lottoTickets.add(issueLottoTicketAuto());
        }
        return new LottoTicketList(lottoTickets);
    }

    public LottoTicket issueLottoTicketManual() {
        return new LottoTicketManual(inputView.getManualLottoNumbers());
    }

    public LottoTicket issueLottoTicketAuto() {
        Collections.shuffle(allLottoNumbers);
        List<LottoNumber> lottoTicket = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lottoTicket.add(allLottoNumbers.get(i));
        }
        Collections.sort(lottoTicket);
        return new LottoTicketAuto(lottoTicket);
    }

    private void validateBuyLottoTickets(Money purchaseAmount, Count manualLottoTicketCount) {
        if (manualLottoTicketCount.value() * PRICE.value() > purchaseAmount.value()) {
            throw new LottoMachineNotEnoughMoneyException();
        }
    }

}
