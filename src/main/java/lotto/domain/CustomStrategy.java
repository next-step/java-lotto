package lotto.domain;

import lotto.exception.InvalidLottoNumber;

import java.util.*;

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

    public static CustomStrategy of(Integer... customNumbers) {
        return new CustomStrategy(Arrays.asList(customNumbers));
    }

    @Override
    public Set<Integer> generateNumbers() {
        return customNumbers;
    }

    @Override
    public Integer generateNumber() {
        if (generator.hasNext()) {
            return generator.next();
        }
        throw new InvalidLottoNumber(this.customNumbers.toString());
    }
}
