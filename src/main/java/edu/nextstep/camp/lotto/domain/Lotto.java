package edu.nextstep.camp.lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_NUMBERS_LENGTH = 6;

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(LottoNumber... lottoNumbers) {
        this(Arrays.asList(lottoNumbers));
    }

    public Lotto(String... lottoNumbers) {
        this(Arrays.stream(lottoNumbers)
                .map(LottoNumber::of)
                .collect(Collectors.toList())
        );
    }

    public Lotto(Integer... lottoNumbers) {
        this(Arrays.stream(lottoNumbers)
                .map(LottoNumber::of)
                .collect(Collectors.toList())
        );
    }

    public Lotto(List<LottoNumber> lottoNumberList) {
        validationCheck(lottoNumberList);

        this.lottoNumbers = new HashSet<>(lottoNumberList);
    }

    public int matchNumberCount(Lotto compareNumbers) {
        Set<LottoNumber> lottoNumberCopy = new HashSet<>(lottoNumbers);

        lottoNumberCopy.retainAll(compareNumbers.lottoNumbers);

        return lottoNumberCopy.size();
    }

    public boolean isMatchBonus(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
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
        return lottoNumbers.stream()
                .sorted()
                .toString();
    }

    public boolean contains(LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }
}
