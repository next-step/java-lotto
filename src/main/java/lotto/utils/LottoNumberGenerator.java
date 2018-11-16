package lotto.utils;

import lotto.domain.LottoNo;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.domain.LottoNo.LOTTO_NUMBER_BOUND;

public class LottoNumberGenerator {

    public static final int LOTTO_NUMBER_LENGTH = 6;

    private LottoNumberGenerator() {

    }

    public static List<LottoNo> generate(int... numbers) {
        return generate(Arrays.stream(numbers).boxed().collect(Collectors.toList()));
    }
    
    public static List<LottoNo> generate(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumberGenerator::create)
                .collect(Collectors.toList());
    }

    public static List<LottoNo> generate() {
        List<LottoNo> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_NUMBER_LENGTH; i++) {
            lottoNumbers.add(create(random()));
        }
        Collections.shuffle(lottoNumbers);
        return lottoNumbers;
    }

    private static LottoNo create(int number) {
        return LottoNumberStore.exists(number) ?
                LottoNumberStore.get(number) :
                LottoNumberStore.put(number, LottoNo.create(number));
    }

    private static int random() {
       return new Random().nextInt(LOTTO_NUMBER_BOUND);
    }
}
