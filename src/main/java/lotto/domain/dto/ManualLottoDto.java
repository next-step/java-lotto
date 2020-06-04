package lotto.domain.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ManualLottoDto {
    private final List<Integer> manualNumbers;

    public ManualLottoDto(String[] stringNumbers) {
        try {
            this.manualNumbers = Stream.of(stringNumbers)
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요. - " + Arrays.toString(stringNumbers));
        }
    }

    public List<Integer> getManualNumbers() {
        return manualNumbers;
    }
}
