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

    public LottoMachine() {
        allLottoNumbers = new ArrayList<>();
        for (int i = LottoNumber.MIN_VALUE; i <= LottoNumber.MAX_VALUE; i++) {
            allLottoNumbers.add(LottoNumber.of(i));
        }
    }

    public LottoTicketList buyLottoTickets(Money purchaseAmount) {
        return buyLottoTickets(purchaseAmount, new String[0]);
    }

    public LottoTicketList buyLottoTickets(Money purchaseAmount, String[] manualLottoNumbersList) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        validateBuyLottoTickets(purchaseAmount, new Count(manualLottoNumbersList.length));
        for (String s : manualLottoNumbersList) {
            lottoTickets.add(issueLottoTicketManual(s));
            purchaseAmount.subtract(PRICE);
        }
        Count ticketCount = new Count(purchaseAmount.value() / PRICE.value());
        for (int i = 0; i < ticketCount.value(); i++) {
            lottoTickets.add(issueLottoTicketAuto());
        }
        return new LottoTicketList(lottoTickets);
    }

    public LottoTicket issueLottoTicketManual(String manualLottoNumbers) {
        return new LottoTicketManual(manualLottoNumbers);
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

    public void validateBuyLottoTickets(Money purchaseAmount, Count manualLottoTicketCount) {
        if (manualLottoTicketCount.value() * PRICE.value() > purchaseAmount.value()) {
            throw new LottoMachineNotEnoughMoneyException();
        }
    }

}
