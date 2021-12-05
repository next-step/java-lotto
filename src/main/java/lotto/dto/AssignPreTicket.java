package lotto.dto;

import static utils.IntegerValidator.getNumberIfPositive;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.Wallet;

public class AssignPreTicket {

    private final Wallet wallet;
    private final int assignCount;

    public AssignPreTicket(Wallet wallet, int assignCount) {
        this.wallet = wallet;
        this.assignCount = getNumberIfPositive(assignCount);
    }

    public static AssignPreTicket buy(Wallet wallet, int assignCount) {
        Wallet deductedWallet = wallet.spend(LottoTicket.PRICE * assignCount);

        return new AssignPreTicket(deductedWallet, assignCount);
    }

    public int getAssignCount() {
        return assignCount;
    }

    public BuyTickets getAllBuyTickets(LottoTickets assignLottoTickets, LottoMachine lottoMachine) {
        return new BuyTickets(assignLottoTickets, buyAbleAllTickets(lottoMachine));
    }

    private LottoTickets buyAbleAllTickets(LottoMachine lottoMachine) {
        return new LottoTickets(
            IntStream.range(0, wallet.getNumberOfBuyAvailable(LottoTicket.PRICE)).boxed()
                .map(n -> lottoMachine.publish())
                .collect(Collectors.toList()));
    }
}
