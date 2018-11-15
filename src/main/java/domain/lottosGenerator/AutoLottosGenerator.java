package domain.lottosGenerator;

import domain.Lotto;
import domain.LottoNumber;
import domain.Money;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottosGenerator implements LottosGenerator {

    private static final int PICK = 6;
    private static final Map<Integer, LottoNumber> NUMBER_CANDIDATES = new HashMap<>();

    static {
        IntStream
            .range(LottoNumber.MINIMUM_NUMBER, LottoNumber.MAXIMUM_NUMBER + 1)
            .forEach(i -> NUMBER_CANDIDATES.put(i, new LottoNumber(i)));
    }

    @Override
    public List<Lotto> generate(Money money) {
        List<Lotto> games = new ArrayList<>();
        for (int i = 0; i < money.getGameCount(); i++) {
            games.add(new Lotto(generateNumbers()));
        }

        return games;
    }

    public List<LottoNumber> generateNumbers() {
        List<Integer> numbers = IntStream
            .range(LottoNumber.MINIMUM_NUMBER, LottoNumber.MAXIMUM_NUMBER + 1)
            .boxed()
            .collect(Collectors.toList());

        Collections.shuffle(numbers);

        return numbers.subList(0, PICK)
            .stream()
            .map(NUMBER_CANDIDATES::get)
            .sorted()
            .collect(Collectors.toList());
    }
}
