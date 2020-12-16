package lotto.domain.machine;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import lotto.domain.LottoTicket;
import lotto.domain.LottoUserRequest;

public class ComplexTicketMachine {

    private final List<TicketMachine> ticketMachineChain;

    public ComplexTicketMachine() {
        this.ticketMachineChain = Arrays.asList(new RandomTicketMachine(), new ManualTicketMachine());
    }

    public ComplexTicketMachine(TicketMachine... ticketMachines) {
        validate(ticketMachines);
        ticketMachineChain = Arrays.asList(ticketMachines);
    }

    private void validate(TicketMachine[] ticketMachines) {
        if (ticketMachines == null) {
            throw new IllegalArgumentException("사용하려는 티켓 생성방식이 존재하지 않습니다.");
        }
    }

    public List<LottoTicket> issue(LottoUserRequest lottoUserRequest) {
        return ticketMachineChain.stream()
              .filter(ticketMachine -> ticketMachine.hasTarget(lottoUserRequest))
              .map(ticketMachine -> ticketMachine.issue(lottoUserRequest))
              .flatMap(Collection::stream)
              .collect(toList());
    }
}
