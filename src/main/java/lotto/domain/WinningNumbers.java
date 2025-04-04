package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final List<LottoNumber> numbers;

    public WinningNumbers(String input) {
        List<LottoNumber> arr = Arrays.stream(input.split(","))
                .map(s -> new LottoNumber(Integer.parseInt(s.trim())))
                .collect(Collectors.toList());
        validateWinningNumbers(arr);
        this.numbers = arr;
    }

    private void validateWinningNumbers(List<LottoNumber> arr) {
        if (arr.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
        }
        if (new HashSet<>(arr).size() != arr.size()) {
            throw new IllegalArgumentException("당첨 번호는 중복될 수 없습니다.");
        }
    }

    public int countNumberMatching(Lotto lotto) {
        return lotto.getMatchCount(this.numbers);
    }
}
