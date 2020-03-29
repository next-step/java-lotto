package lotto.common;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoFeatureSetup {

    private LottoFeatureSetup() {
    }

    public static List<LottoNumber> getLottoNubersOneToSix() {
        return Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
    }

    public static List<LottoNumber> getLottoNubersTwoToSeven() {
        return Arrays.asList(new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(6), new LottoNumber(7));
    }

    public static List<LottoNumber> getLottoNubers(int... number) {
        return Arrays.stream(number)
                .mapToObj(LottoNumber::new).collect(Collectors.toList());
    }

    public static LottoTicket getLottoTicket(LottoNumber... lottoNumbers) {
        return new LottoTicket(Arrays.asList(lottoNumbers));
    }

    public static LottoTicket getLottoTicket(List<LottoNumber> lottoNumbers) {
        return new LottoTicket(lottoNumbers);
    }

    public static LottoTickets getLottoTickets(LottoTicket... lottoTickets) {
        return new LottoTickets(Arrays.asList(lottoTickets));
    }

    public static LottoTickets getLottoTickets(List<LottoTicket> lottoTickets) {
        return new LottoTickets(lottoTickets);
    }

}
