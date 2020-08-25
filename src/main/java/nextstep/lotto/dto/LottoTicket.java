package nextstep.lotto.dto;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static nextstep.lotto.constant.ExceptionMessage.INVALID_LOTTO_NUMBER_SIZE;

public class LottoTicket {

    private Set<LottoNumber> ticket;

    private LottoTicket(List<LottoNumber> numbers) {
        this.ticket = numbers.stream().collect(Collectors.toSet());

        if (ticket.size() != 6) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_SIZE);
        }
    }

    public static LottoTicket create(List<LottoNumber> numbers) {
        return new LottoTicket(numbers);
    }

    public List<LottoNumber> getLottoNumber() {
        List<LottoNumber> lottoTicket = this.ticket.stream().collect(Collectors.toList());
        Collections.sort(lottoTicket);
        return Collections.unmodifiableList(
                lottoTicket
        );
    }
}
