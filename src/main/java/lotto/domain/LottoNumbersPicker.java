package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
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
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() < MAX_BOUNDARY_AMOUNT) {
            int number = random.nextInt(MAX_BOUNDARY_NUMBER) + 1;
            lottoNumbers.add(LottoNumber.of(number));
        }
        List<LottoNumber> lottoNumberList = new ArrayList<>(lottoNumbers);
        lottoNumberList.sort(Comparator.comparingInt(LottoNumber::getNumber));
        return lottoNumberList;
    }
}