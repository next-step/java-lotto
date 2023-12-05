package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTicket {
    private final List<LottoNumbers> lottoTicket;

    public LottoTicket(List<LottoNumbers> lottoNumbers) {
        this.lottoTicket = lottoNumbers;
    }

    public LottoTicket(int numberOfTickets) {
        this.lottoTicket = generateAutoTicket(numberOfTickets);
    }

    private List<LottoNumbers> generateAutoTicket(int numberOfTickets) {
        return Stream.generate(LottoNumbers::new)
                .limit(numberOfTickets)
                .collect(Collectors.toList());
    }

    public static LottoTicket mergeLottoTicket(LottoTicket autoLottoTicket, List<String> list) {
        List<LottoNumbers> manualTicket = new ArrayList<>();
        for(String input : list) {
            manualTicket.add(new LottoNumbers(input));
        }
        return new LottoTicket(Collections.unmodifiableList(Stream.concat(manualTicket.stream(), autoLottoTicket.getLottoTicket().stream())
                .collect(Collectors.toList())));
    }

    public List<LottoNumbers> getLottoTicket() {
        return lottoTicket;
    }
}
