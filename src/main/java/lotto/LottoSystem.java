package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoSystem {
    private static final int PRICE_PER_LOTTO = 1_000;
    private static final int LOTTO_NUMBER_TOTAL_COUNT = 45;
    private static final int LOTTO_LIMITED_COUNT = 6;
    private List<Lotto> lottos = new ArrayList<>();

    public LottoSystem() { }

    static int calcLottoCount(int cost) {
        return cost / PRICE_PER_LOTTO;
    }

    static List<Integer> lottoNumbersSetting() {
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < LOTTO_NUMBER_TOTAL_COUNT; i++){
            numbers.add(i + 1);
        }

        return numbers;
    }

    List<Lotto> makeLottoList(List<Integer> numbers, int lottoCount) {
        List<Integer> lottoNumber;

        for(int i = 0; i < lottoCount; i++) {
            lottoNumber = new ArrayList<>();
            shuffleNumbers(numbers);

            for(int j = 0; j < LOTTO_LIMITED_COUNT; j++){
                lottoNumber.add(numbers.get(j));
            }

            sortLottoNumbers(lottoNumber);
            lottos.add(Lotto.from(lottoNumber));
        }

        return lottos;
    }

    static void sortLottoNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    private static void shuffleNumbers(List<Integer> numbers) {
        Collections.shuffle(numbers);
    }
}
