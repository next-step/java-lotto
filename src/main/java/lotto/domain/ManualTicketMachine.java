package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ManualTicketMachine implements TicketMachine2 {

    @Override
    public boolean hasTarget(LottoUserRequest lottoUserRequest) {
        return lottoUserRequest.hasManualIssueTarget();
    }

    @Override
    public List<LottoTicket> issue(LottoUserRequest lottoUserRequest) {
        Optional<List<String>> maybeManualNumbers = lottoUserRequest.getManualNumbers();

        if (!maybeManualNumbers.isPresent()) {
            return Collections.emptyList();
        }

        return maybeManualNumbers.get().stream()
              .map(LottoTicket::new)
              .collect(Collectors.toList());
    }
}
