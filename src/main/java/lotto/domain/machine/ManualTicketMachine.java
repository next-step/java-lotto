package lotto.domain.machine;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoTicket;
import lotto.domain.LottoUserRequest;

public class ManualTicketMachine implements TicketMachine {

    @Override
    public boolean hasTarget(LottoUserRequest lottoUserRequest) {
        return lottoUserRequest.hasManualIssueTarget();
    }

    @Override
    public List<LottoTicket> issue(LottoUserRequest lottoUserRequest) {
        List<String> manualNumbers = lottoUserRequest.getManualNumbers();

        if (manualNumbers.isEmpty()) {
            return Collections.emptyList();
        }

        return manualNumbers.stream()
              .map(LottoTicket::new)
              .collect(Collectors.toList());
    }
}
