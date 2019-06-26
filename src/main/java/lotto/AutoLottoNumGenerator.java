package lotto;


import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoNumGenerator implements LottoNumGenerator {

    public List<Integer> generate() {

        Random random = new Random();
        IntStream is = random.ints(LottoNumGenerator.MIN_INT, LottoNumGenerator.MAX_INT + 1);
        return is.distinct().limit(6).boxed().sorted().collect(Collectors.toList());
    }

}
