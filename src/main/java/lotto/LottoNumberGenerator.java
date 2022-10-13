package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoNumberGenerator {

    public static List<Integer> generate() {
        Random random = new Random(System.currentTimeMillis());

        List<Integer> lottoNumbers = new ArrayList<>();

        Integer randomNumber = null;
        while(lottoNumbers.size() <6) {
            randomNumber = random.nextInt(46);

            if (!lottoNumbers.contains(randomNumber)) {
                lottoNumbers.add(randomNumber);
            }
        }

        return List.copyOf(lottoNumbers);
    }
}
