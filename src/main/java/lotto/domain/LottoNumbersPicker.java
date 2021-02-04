package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class LottoNumbersPicker {
    private static final int MAX_BOUNDARY_NUMBER = 45;
    private static final int MAX_BOUNDARY_AMOUNT = 6;
    private static final Random random = new Random();

    private LottoNumbersPicker() {
    }

    public static List<LottoNumber> pick() {
        List<LottoNumber> lottoNumbers = createNonDuplicateLottoNumbers();
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    private static List<LottoNumber> createNonDuplicateLottoNumbers() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() < MAX_BOUNDARY_AMOUNT) {
            int number = random.nextInt(MAX_BOUNDARY_NUMBER) + 1;
            lottoNumbers.add(LottoNumber.of(number));
        }
        return new ArrayList<>(lottoNumbers);
    }
}