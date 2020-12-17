package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FixedLottoMachine {

    public LottoTickets generate(List<String> manualPurchaseLottoNumbers) {
        return new LottoTickets(manualPurchaseLottoNumbers.stream()
                .map(this::generate)
                .collect(Collectors.toList()));
    }

    private LottoTicket generate(String manualPurchaseLottoNumber) {
        return new LottoTicket(Arrays.stream(manualPurchaseLottoNumber.split(", "))
                .map(s -> new LottoNumber(Integer.parseInt(s)))
                .collect(Collectors.toList()));
    }
}
