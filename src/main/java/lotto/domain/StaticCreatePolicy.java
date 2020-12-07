package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StaticCreatePolicy implements LottoTicketCreatePolicy {
    private final List<Integer> numbers;

    public StaticCreatePolicy(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    @Override
    public LottoTicket create() {
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        return new LottoTicket(lottoNumbers);
    }
}
