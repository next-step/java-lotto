package edu.nextstep.camp.lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_NUMBERS_LENGTH = 6;

    private final Set<LottoNumber> lottoNumbers;

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

        List<LottoNumber> lottoNumbers = new ArrayList<>(lottoNumberList);

        lottoNumbers.sort(LottoNumber::compareTo);

        this.lottoNumbers = new LinkedHashSet<>(lottoNumbers);
    }

    public int matchNumberCount(Lotto compareNumbers) {
        Set<LottoNumber> lottoNumberCopy = new HashSet<>(lottoNumbers);

        lottoNumberCopy.retainAll(compareNumbers.lottoNumbers);

        return lottoNumberCopy.size();
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
