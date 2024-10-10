package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbers {
    public static final String DELIMITER = ", ";

    private final Set<Integer> winningNumbers;

    public static WinningNumbers from(String inputWinningNumbers) {
        Set<Integer> winningNumbers = Arrays.stream(inputWinningNumbers.split(DELIMITER))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toSet());

        return new WinningNumbers(winningNumbers);
    }

    public WinningNumbers(Set<Integer> winningNumbers) {
        if (winningNumbers == null || winningNumbers.isEmpty()) {
            throw new IllegalArgumentException("당첨번호는 null 이거나 비어있을 수 없습니다");
        }
        this.winningNumbers = winningNumbers;
    }

    public int equalNumberCount(Set<Integer> lottoNumbers) {
        Set<Integer> equalNumbers = new HashSet<>(winningNumbers);
        equalNumbers.retainAll(lottoNumbers);

        return equalNumbers.size();
    }

    public List<Integer> equalNumberCountList(List<Set<Integer>> lottoNumbersList) {
        return lottoNumbersList.stream()
                .map(this::equalNumberCount)
                .collect(Collectors.toList());
    }
}
