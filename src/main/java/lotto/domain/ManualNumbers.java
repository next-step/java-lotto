package lotto.domain;

import lotto.util.StringUtils;

import java.util.List;
import java.util.stream.Stream;

public class ManualNumbers {

    private final List<String> manualNumbers;

    private ManualNumbers(List<String> manualNumbers) {
        validate(manualNumbers);
        this.manualNumbers = manualNumbers;
    }

    public static ManualNumbers newInstance(List<String> manualNumbers) {
        return new ManualNumbers(manualNumbers);
    }

    private void validate(List<String> manualNumbers) {
        if (manualNumbers == null) {
            throw new IllegalArgumentException("수동 번호 묶음이 존재하지 않습니다.");
        }

        if (manualNumbers.stream().anyMatch(StringUtils::isBlank)) {
            throw new IllegalArgumentException("수동 번호가 존재하지 않습니다.");
        }
    }

    public Stream<String> stream() {
        return this.manualNumbers.stream();
    }

    public int getCount() {
        return this.manualNumbers.size();
    }
}
