package lotto.domain.strategy;

import lotto.domain.item.LottoNumbers;
import lotto.domain.item.LottoTicket;
import lotto.domain.item.LottoTickets;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketGenerator {

    public static LottoTickets generateAutoLotto(int count) {
        List<LottoTicket> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            LottoNumbers numbers = LottoNumbers.createLottoNumbersUseInteger(LottoNumberAutoGenerator.generateLottoNumber());
            result.add(new LottoTicket(numbers));
        }
        return new LottoTickets(result);
    }

    public static LottoTickets generatePassivityLotto(List<LottoNumbers> numbers) {
        List<LottoTicket> tickets = numbers.stream()
                .map(LottoTicket::new)
                .collect(Collectors.toList());
        return new LottoTickets(tickets);
    }
}
