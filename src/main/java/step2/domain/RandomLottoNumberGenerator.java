package step2.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

class RandomLottoNumberGenerator implements LottoNumberGenerator {
    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    @Override
    public LottoNumbers generate() {
        List<Integer> randomNumbers = generateNoDuplicate();
        return new LottoNumbers(randomNumbers);
    }

    private List<Integer> generateNoDuplicate() {
        final Set<Integer> numbers = new HashSet<>();
        while (numbers.size() != LottoNumbers.COUNT) {
            populate(numbers);
        }
        return new ArrayList<>(numbers);
    }

    private void populate(final Set<Integer> numbers) {
        final int candidate = random.nextInt(LottoNumbers.MIN_NUMBER, LottoNumbers.MAX_NUMBER + 1);
        if (numbers.contains(candidate)) {
            return;
        }
        numbers.add(candidate);
    }
}
