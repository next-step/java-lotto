package lotto.domain;

import lotto.strategy.NumberStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_NUMBER_SIZE = 6;
    private List<Integer> lottoNumbers;

    public Lotto() {
        lottoNumbers = new ArrayList<>();
    }

    public void generateLottoNumber(NumberStrategy numberStrategy) {
        while (lottoNumbers.size() < LOTTO_NUMBER_SIZE) {
            int lottoNumber = numberStrategy.create();
            duplicateNumberCheck(lottoNumber);
        }
        sortLotto();
    }

    private void duplicateNumberCheck(int lottoNumber) {
        if (!lottoNumbers.contains(lottoNumber)) {
            lottoNumbers.add(lottoNumber);
        }
    }

    private void sortLotto() {
        lottoNumbers = lottoNumbers.stream().sorted().collect(Collectors.toList());
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
