package lottogame.randomnumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import lottogame.domain.LottoNumber;
import lottogame.domain.spi.NumberGenerator;

public class RandomNumberGenerator implements NumberGenerator {

    private final Random random = new Random();

    @Override
    public List<Integer> generate(int count) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            answer.add(random.nextInt(LottoNumber.MAX_LOTTO_NUMBER - LottoNumber.MIN_LOTTO_NUMBER)
                + LottoNumber.MIN_LOTTO_NUMBER);
        }
        return answer;
    }
}
