package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoNumbersGenerator {
    public static final String MANUAL_COUNT_NOT_MATCH_ERROR_MESSAGE = "수동 구매 개수와 수동 번호 개수가 같아야 합니다";

    public List<LottoNumbers> generate(int manualCount, List<String> manualNumbers) {
        validateManualNumbersLength(manualCount, manualNumbers);
        return manualNumbers.stream()
                .map(LottoNumbers::of)
                .collect(Collectors.toList());
    }

    private void validateManualNumbersLength(int manualCount, List<String> manualNumbers) {
        if (manualCount > 0 && manualNumbers == null || manualCount != manualNumbers.size()) {
            throw new IllegalArgumentException(MANUAL_COUNT_NOT_MATCH_ERROR_MESSAGE);
        }
    }
}
