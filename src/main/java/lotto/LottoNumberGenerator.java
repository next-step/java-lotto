package lotto;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LottoNumberGenerator {

    public static int[] generate() {
        Random random = new Random(System.currentTimeMillis());
        Set<Integer> lottoNumbers = new HashSet<>();

        while(lottoNumbers.size() <6) {
            lottoNumbers.add(random.nextInt(46));
        }

        return lottoNumbers.stream().mapToInt(Integer::intValue).toArray();
    }
}
