package edu.nextstep.camp.lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_NUMBERS_LENGTH = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(LottoNumber... lottoNumbers) {
        this(Arrays.asList(lottoNumbers));
    }

    public Lotto(Integer... lottoNumbers){
        this(Arrays.stream(lottoNumbers)
                .map(LottoNumber::new)
                .collect(Collectors.toList())
        );
    }

    public Lotto(List<LottoNumber> lottoNumberList) {
        validationCheck(lottoNumberList);

        this.lottoNumbers = new ArrayList<>(lottoNumberList);

        this.lottoNumbers.sort(LottoNumber::compareTo);
    }

    public int matchNumberCount(Lotto compareNumbers) {
        int count = 0;

        for (LottoNumber compareNumber : compareNumbers.lottoNumbers) {
            count += frequencyOfCompareNumber(compareNumber);
        }

        return count;
    }

    private int frequencyOfCompareNumber(LottoNumber compareNumber) {
        return Collections.frequency(lottoNumbers, compareNumber);
    }

    private void validationCheck(List<LottoNumber> lottoNumbers) {
        emptyCheck(lottoNumbers);

        lengthCheck(lottoNumbers);

        duplicateCheck(lottoNumbers);
    }

    private void duplicateCheck(List<LottoNumber> lottoNumbers) {
        if (new HashSet<>(lottoNumbers).size() < lottoNumbers.size()) {
            throw new IllegalArgumentException("duplicate numbers");
        }
    }

    private void emptyCheck(List<LottoNumber> lottoNumbers) {
        if (Objects.isNull(lottoNumbers) || lottoNumbers.isEmpty()) {
            throw new IllegalArgumentException("lottoNumbers null or empty");
        }
    }

    private void lengthCheck(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_LENGTH) {
            throw new IllegalArgumentException("lottoNumbers length isn't 6");
        }
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
