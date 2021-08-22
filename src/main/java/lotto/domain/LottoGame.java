package lotto.domain;

import lotto.generic.Money;
import lotto.util.LottoNumbersFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoGame {
    public static final Money LOTTO_PRICE = Money.wons(1000L);

    public static LottoTickets buy(Money money, String[] manualLottoNumbers) {
        List<LottoNumbers> manualLottoTickets = makeManualLottoTickets(manualLottoNumbers);
        int autoTicketCount = calculateAutoTicketCount(money, manualLottoTickets.size());
        List<LottoNumbers> lottoTickets = makeLottoTickets(manualLottoTickets, autoTicketCount);
        return new LottoTickets(lottoTickets, autoTicketCount);
    }

    private static List<LottoNumbers> makeManualLottoTickets(String[] manualLottoNumbers) {
        return Arrays.stream(manualLottoNumbers)
                .map(LottoNumbersFactory::makeLottoNumbers)
                .collect(toList());
    }

    private static int calculateAutoTicketCount(Money money, int manualLottoCount) {
        Money amount = money.minus(LOTTO_PRICE.times(manualLottoCount));
        return amount.divideAndDiscardRemainder(LOTTO_PRICE);
    }

    private static List<LottoNumbers> makeLottoTickets(List<LottoNumbers> manualLottoTickets, int autoTicketCount) {
        manualLottoTickets.addAll(IntStream.range(0, new TicketCount(autoTicketCount).getValue())
                .mapToObj(index -> LottoNumbersFactory.makeAutoLottoNumbers())
                .collect(toList()));
        return manualLottoTickets;
    }
}
