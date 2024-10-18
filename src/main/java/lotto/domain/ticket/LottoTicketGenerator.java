package lotto.domain.ticket;

import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class LottoTicketGenerator {

    public static LottoTickets generateLottoTickets(List<List<Integer>> manualPurchaseLottoNumbers, int autoLottoPurchaseCount, LottoNumberGenerator generator) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (List<Integer> manualPurchaseLottoNumber : manualPurchaseLottoNumbers) {
            lottoTickets.add(generateLottoTicket(manualPurchaseLottoNumber));
        }

        for (int i = 0; i < autoLottoPurchaseCount; i++) {
            lottoTickets.add(generateLottoTicket(generator.create()));
        }

        return LottoTickets.of(lottoTickets);
    }

    private static LottoTicket generateLottoTicket(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream()
                .sorted()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
        return LottoTicket.of(lottoNumbers);
    }

}
