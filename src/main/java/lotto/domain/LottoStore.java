package lotto.domain;

import lotto.util.ListConverter;

import java.util.ArrayList;
import java.util.List;

public final class LottoStore {

    private LottoStore() {}

    public static List<LottoTicket> sellLottoTicket(final LottoMoney lottoMoney, List<String> stringManualNumbers) {
        final int numberOfAutoLottoTicket = getNumberOfAutoTicket(lottoMoney, stringManualNumbers.size());

        final List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.addAll(sellManualLottoTicket(stringManualNumbers));
        lottoTickets.addAll(sellAutoLottoTicket(numberOfAutoLottoTicket));
        return lottoTickets;
    }

    private static List<LottoTicket> sellManualLottoTicket(final List<String> stringManualNumbers) {
        final List<LottoTicket> lottoTickets = new ArrayList<>();

        for (String stringManualNumber : stringManualNumbers) {
            final List<LottoNumber> lottoNumbers = ListConverter.convertCommaStringToLottoNumbers(stringManualNumber);
            lottoTickets.add(new CustomLottoTicket(lottoNumbers));
        }
        return lottoTickets;
    }

    private static List<LottoTicket> sellAutoLottoTicket(final int numberOfAutoLottoTicket) {
        final List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < numberOfAutoLottoTicket; i++) {
            final LottoTicket lottoTicket = new AutoLottoTicket();
            lottoTickets.add(lottoTicket);
        }
        return lottoTickets;
    }

    public static int getNumberOfAutoTicket(final LottoMoney lottoMoney, final int numberOfManualLotto) {
        if (!lottoMoney.canBuyLottoTicket(numberOfManualLotto)) {
            throw new IllegalArgumentException();
        }
        return lottoMoney.getNumberOfLottoByMoneyPaid() - numberOfManualLotto;
    }

}
