package lotto.domain;

import lotto.exception.InvalidLottoNumber;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CustomStrategy implements Strategy{
    private final Set<Integer> customNumbers = new HashSet<>();
    private final Iterator<Integer> generator;

    public CustomStrategy(List<Integer> customNumbers) {
        for (Integer number : customNumbers) {
            verifyNumber(number);
            this.customNumbers.add(number);
        }
        generator = this.customNumbers.iterator();
    }

    public static CustomStrategy of(List<Integer> customNumbers) {
        return new CustomStrategy(customNumbers);
    }

    @Override
    public Integer generateNumber() {
        if (generator.hasNext()) {
            return generator.next();
        }
        throw new InvalidLottoNumber(this.customNumbers.toString());
    }
}
