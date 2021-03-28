package step2;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomLottoNumberGenerator implements LottoNumberGenerator{

    private static final int LOTTO_BOUND = 45;
    private static final int LOTTO_VOLUME = 6;

    private static List<Integer> numberList;

    public RandomLottoNumberGenerator(){ }

    static {
        numberList = Stream.iterate(1, n -> n + 1)
                .limit(LOTTO_BOUND)
                .collect(Collectors.toList());
    }

    public Lotto generate(){
        Collections.shuffle(numberList);
        return new Lotto(numberList.stream().
                limit(LOTTO_VOLUME)
                .sorted()
                .map(number->new LottoNumber(number))
                .collect(Collectors.toList()));
    }
}
