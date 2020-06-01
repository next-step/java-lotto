package lotto.dto;

import lotto.domain.LottoNumber;
import lotto.domain.ticket.LottoTicket;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class ManualLottoNumbers {
    private static final String MANUAL_LOTTO_NUMBERS_DELIMITER = ",";

    private final Set<LottoNumber> manualLottoNumbers;

    public ManualLottoNumbers(String manualLottoNumbers) {
        this.manualLottoNumbers = Arrays.stream(manualLottoNumbers.split(MANUAL_LOTTO_NUMBERS_DELIMITER))
                .map(number -> Integer.parseInt(number.trim()))
                .map(LottoNumber::of)
                .collect(toSet());
    }

    public LottoTicket toLottoTicket() {
        return new LottoTicket(Collections.unmodifiableSet(manualLottoNumbers));
    }
}
