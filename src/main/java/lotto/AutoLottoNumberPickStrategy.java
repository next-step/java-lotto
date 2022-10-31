package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.stream.Collectors.toList;

public class AutoLottoNumberPickStrategy implements LottoNumberPickStrategy {

    @Override
    public List<Integer> pickNumbers() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < 6) {
            numbers.add(ThreadLocalRandom.current().nextInt(LottoNumber.MAX_LOTTO_NUMBER) + 1);
        }
        return numbers.stream().sorted().collect(toList());
    }

}
