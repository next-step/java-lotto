package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Rank;

public class LottoMatcher {

    public static Rank compare(WinningNumber winningNumber, List<Integer> lotto) {
        int count = 0;
        boolean bonusBall = false;

        List<LottoNumber> winningLottoNumbers = winningNumber.getNumbers();
        LottoNumber bonus = winningNumber.getBonus();

        List<Integer> list = winningLottoNumbers.stream()
            .map(LottoNumber::getNumber)
            .collect(Collectors.toList());

        for (Integer number : lotto) {
            if (isContain(list, number)) {
                count++;
            }
        }

        if (count == 5) {
            bonusBall = isContain(lotto, bonus.getNumber());
        }
        return Rank.find(count, bonusBall);
    }

    public static boolean isContain(List<Integer> numbers, int number) {
        return numbers.contains(number);
    }
}
