package lotto.domain;

import lotto.util.ListConverter;

import java.util.ArrayList;
import java.util.List;

public final class LottoStore {

    private LottoStore() {}

    public static List<LottoTicket> sellAutoLottoTicket(final int numberOfAutoLottoTicket) {
        final List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < numberOfAutoLottoTicket; i++) {
            final LottoTicket lottoTicket = new AutoLottoTicket();
            lottoTickets.add(lottoTicket);
        }
        return lottoTickets;
    }

    public static List<LottoTicket> sellManualLottoTicket(final List<String> stringManualNumbers) {
        final List<LottoTicket> lottoTickets = new ArrayList<>();

        for (String stringManualNumber : stringManualNumbers) {
            final List<LottoNumber> lottoNumbers = ListConverter.convertCommaStringToLottoNumbers(stringManualNumber);
            lottoTickets.add(new CustomLottoTicket(lottoNumbers));
        }
        return lottoTickets;
    }
}
