package lotto.dto;

import static utils.IntegerValidator.getNumberIfPositive;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.LottoMachine;
import lotto.domain.LottoTickets;
import lotto.domain.Wallet;

public class AssignBuyPreTicket {

    private final Wallet wallet;
    private final int assignCount;

    public AssignBuyPreTicket(Wallet wallet, int assignCount) {
        this.wallet = wallet;
        this.assignCount = getNumberIfPositive(assignCount);
    }

    public int getAssignCount() {
        return assignCount;
    }

    public BuyTickets getResultDto(LottoTickets assignLottoTickets, LottoMachine lottoMachine) {
        return new BuyTickets(assignLottoTickets, buyAbleAllTickets(lottoMachine));
    }

    private LottoTickets buyAbleAllTickets(LottoMachine lottoMachine) {
        return new LottoTickets(
            IntStream.range(0, wallet.getNumberOfBuyAvailableLottoTicket()).boxed()
                .map(n -> lottoMachine.publish())
                .collect(Collectors.toList()));
    }
}
