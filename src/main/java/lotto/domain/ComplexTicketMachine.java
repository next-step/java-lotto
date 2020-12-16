package lotto.domain;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ComplexTicketMachine {

    private final List<TicketMachine2> ticketMachineChain;

    public ComplexTicketMachine() {
        this.ticketMachineChain = Arrays.asList(new RandomTicketMachine2(), new ManualTicketMachine());
    }

    public ComplexTicketMachine(TicketMachine2... ticketMachines) {
        validate(ticketMachines);
        ticketMachineChain = Arrays.asList(ticketMachines);
    }

    private void validate(TicketMachine2[] ticketMachines) {
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
