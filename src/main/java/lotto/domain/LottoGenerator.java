package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoGenerator {
    private static List<LottoNumber> LOTTO_NUMBERS =
            Collections.unmodifiableList(getLottoNumbers());

    public static LottoNumbers generate() {
        List<LottoNumber> copy = new ArrayList<>(List.copyOf(LOTTO_NUMBERS));
        Collections.shuffle(copy);

        List<LottoNumber> lottoNumbers = copy.subList(0, 6);
        Collections.sort(lottoNumbers, Comparator.comparingInt(LottoNumber::getNumber));
        return new LottoNumbers(lottoNumbers.stream()
                .collect(Collectors.toSet()));
    }

    private static List<LottoNumber> getLottoNumbers() {
        LOTTO_NUMBERS = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            LOTTO_NUMBERS.add(new LottoNumber(i));
        }
        return LOTTO_NUMBERS;
    }
}
