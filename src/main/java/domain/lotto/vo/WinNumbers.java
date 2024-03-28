package domain.lotto.vo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinNumbers {

    Set<Integer> primaryNumbers;
    int bounusNumber;

    public WinNumbers(List<Integer> primaryNumbers, int bounusNumber){
        this.primaryNumbers = new HashSet<>(primaryNumbers);
        this.bounusNumber = bounusNumber;
    }

    public int getMatchCount(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .reduce(0, (acc, number) -> acc + (primaryNumbers.contains(number) || number == bounusNumber ? 1 : 0));
    }
}
