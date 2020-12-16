package lotto.domain.machine;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoUserRequest;

public class RandomTicketMachine implements TicketMachine {

    private static final Integer RANGE_MIN = 1;
    private static final Integer RANGE_MAX = 45;
    private final List<LottoNumber> lottoNumbers;

    public RandomTicketMachine() {
        this.lottoNumbers = IntStream.rangeClosed(RANGE_MIN, RANGE_MAX)
              .mapToObj(LottoNumber::new)
              .collect(Collectors.toList());
    }

    @Override
    public boolean hasTarget(LottoUserRequest lottoUserRequest) {
        return lottoUserRequest.hasAutoIssueTarget();
    }

    @Override
    public List<LottoTicket> issue(LottoUserRequest lottoUserRequest) {
        return Stream.generate(() -> {
            shuffle();
            List<LottoNumber> lottoNumbers = this.lottoNumbers.subList(0, 6);
            Collections.sort(lottoNumbers);
            return new LottoTicket(new HashSet<>(lottoNumbers));
        })
              .limit(lottoUserRequest.getAutoTicketCount())
              .collect(Collectors.toList());
    }

    private void shuffle() {
        Collections.shuffle(this.lottoNumbers);
    }
}
