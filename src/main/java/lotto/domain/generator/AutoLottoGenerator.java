package lotto.domain.generator;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Money;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoGenerator implements LottoGenerator {
    private static final int LOTTO_NUMBER_TOTAL_COUNT = 45;
    private static final int LOTTO_LIMITED_COUNT = 6;

    static List<Integer> lottoNumbersSetting() {
        List<Integer> numbers = new ArrayList<>();
        for(int i = 1; i <= LOTTO_NUMBER_TOTAL_COUNT; i++){
            numbers.add(i);
        }

        return numbers;
    }

    @Override
    public List<Lotto> generate(Money money){
        List<Lotto> lottos = new ArrayList<>();
        List<Integer> numbers = lottoNumbersSetting();

        for(int i = 0; i < money.calcLottoCount(); i++) {
            List<Integer> lottoNumber = new ArrayList<>();
            shuffleNumbers(numbers);

            for(int j = 0; j < LOTTO_LIMITED_COUNT; j++){
                lottoNumber.add(numbers.get(j));
            }

            sortLottoNumbers(lottoNumber);
            lottos.add(Lotto.from(lottoNumber));
        }
        return lottos;
    }

    private static void sortLottoNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    private static void shuffleNumbers(List<Integer> numbers) {
        Collections.shuffle(numbers);
    }
}
