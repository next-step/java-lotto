package dev.solar.lotto;

import java.util.Set;
import java.util.stream.Collectors;

import dev.solar.lotto.domain.LottoTicket;

public class LottoService {
    public static LottoTicket mapToLottoTicket(Set<String> lottoNumberStrings) {
        final Set<Integer> lottoNumbers = lottoNumberStrings.stream()
                                                 .map(Integer::parseInt)
                                                 .collect(Collectors.toSet());
        return new LottoTicket(lottoNumbers);
    }
}
