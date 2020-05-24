package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoGenerator {

    private final Random RANDOM = new Random();

    private static final int LOTTO_GENERATE_COUNT = 6;
    private static final int LOTTO_NUMBER_MAX = 45;


    public Lotto autoGenerate() {
        return Lotto.of(generateLottoNumbers());
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();

        while (lottoNumbers.size() < LOTTO_GENERATE_COUNT) {
            add(lottoNumbers, generateNumber());
        }

        return lottoNumbers;
    }

    private int generateNumber() {
        return RANDOM.nextInt(LOTTO_NUMBER_MAX) + 1;
    }

    private void add(List<Integer> lottoNumbers, int number) {
        if (!lottoNumbers.contains(number)) {
            lottoNumbers.add(number);
        }
    }
}
