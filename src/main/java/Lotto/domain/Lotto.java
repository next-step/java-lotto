package Lotto.domain;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> lottoNumbers;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_PICK_COUNT = 6;

    public Lotto() {
        this.lottoNumbers = Arrays.stream(generateLottoNumbers())
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public static int[] generateLottoNumbers () {
        List<Integer> lottoNumbers = new ArrayList<>();

        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            lottoNumbers.add(i);
        }

        Collections.shuffle(lottoNumbers);

        int[] result = new int[LOTTO_PICK_COUNT];
        for (int i = 0; i < LOTTO_PICK_COUNT; i++) {
            result[i] = lottoNumbers.get(i);
        }

        Arrays.sort(result);

        return result;
    }

    public static List<Lotto> generateLottos (int purchasedQty) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < purchasedQty; i++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
