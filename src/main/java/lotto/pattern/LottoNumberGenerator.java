package lotto.pattern;

import lotto.domain.LottoNumber;

import java.security.SecureRandom;
import java.util.*;

public class LottoNumberGenerator implements NumberGenerator {
    private final int MAX_NUMBER_SIZE = 6;
    private final int MAX_VALUE = 45;
    private final SecureRandom random = new SecureRandom();

    @Override
    public int generator() {
        return random.nextInt(MAX_VALUE) + 1;
    }

    public List<LottoNumber> generateLottoNumbers() {
        Set<LottoNumber> randomNumbers = new HashSet<>();
        while (randomNumbers.size() < MAX_NUMBER_SIZE) {
            randomNumbers.add(new LottoNumber(generator()));
        }

        return new ArrayList<>(randomNumbers);
    }
}
