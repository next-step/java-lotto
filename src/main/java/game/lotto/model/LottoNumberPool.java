package game.lotto.model;

import game.lotto.util.RandomNumberGenerator;

import java.util.HashMap;
import java.util.Map;

public class LottoNumberPool {

    private static final Map<Integer, LottoNumber> pool = new HashMap<>();

    public static LottoNumber getLottoNumber(int number) {
        return pool.computeIfAbsent(number, LottoNumber::new);
    }

    public static LottoNumber getRandomLottoNumber() {
        int randomNumber = RandomNumberGenerator.generateStartWithOne(LottoNumber.MAX);
        return getLottoNumber(randomNumber);
    }
}
