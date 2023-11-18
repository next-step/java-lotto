package src.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AutoLottoGameNumberGenerator implements LottoGameNumberGenerator {

    @Override
    public Set<GameNumber> gameNumbers() {
        List<GameNumber> numbers = GameNumber.gameNumbers();
        Collections.shuffle(numbers);

        return new HashSet<>(numbers.subList(0, LOTTO_NUMBER_COUNT));
    }
}
