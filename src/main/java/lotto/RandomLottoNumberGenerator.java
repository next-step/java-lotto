package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {

    private final Random random = new Random();

    @Override
    public List<Integer> generate() {
        List<Integer> randomLottoNumber = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            randomLottoNumber.add(random.nextInt(45) + 1);
        }
        return randomLottoNumber;
    }
}
