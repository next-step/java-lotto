package lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public final class LottoNumberGenerator {

    private LottoNumberGenerator() {

    }

    public static List<Integer> generate() {
        Random random = new Random();

        List<Integer> lottoNumbers = new ArrayList<>();

        Integer randomNumber = null;
        while(lottoNumbers.size() <6) {
            randomNumber = random.nextInt(46);

            if (!lottoNumbers.contains(randomNumber)) {
                lottoNumbers.add(randomNumber);
            }
        }

        lottoNumbers.sort(Comparator.naturalOrder());

        return List.copyOf(lottoNumbers);
    }
}
