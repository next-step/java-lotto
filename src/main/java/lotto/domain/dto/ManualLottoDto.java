package lotto.domain.dto;

import lotto.domain.ticket.LottoTicket;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ManualLottoDto {
    private static final String DELIMITER = ",";
    private final List<Integer> manualNumbers;

    public ManualLottoDto(String stringNumbers) {
        Objects.requireNonNull(stringNumbers, "");
        try {
            this.manualNumbers = Stream.of(stringNumbers.split(DELIMITER))
                    .map(String::trim)
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요. - " + stringNumbers);
        }
    }

    public List<Integer> getManualNumbers() {
        return manualNumbers;
    }
}
