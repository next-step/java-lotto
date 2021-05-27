package com.lotto.domain;

import com.lotto.exception.IllegalLottoCountException;
import com.lotto.exception.LottoNumberFormatException;
import com.lotto.exception.LottoNumberOutOfBoundsException;

import java.util.Objects;
import java.util.TreeSet;

public class Lotto {

    public static final int UNIT_PRICE = 1000;
    public static final int LOTTO_COUNT = 6;

    private TreeSet<LottoNumber> lottoNumbers;

    public Lotto(TreeSet<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        validate();
    }

    public static Lotto createLotto(String sLottoNumbers)
            throws LottoNumberFormatException,
            LottoNumberOutOfBoundsException,
            IllegalLottoCountException {

        TreeSet<LottoNumber> set = castTreeSet(sLottoNumbers);
        validateLottoCount(set);
        return new Lotto(set);
    }

    private static TreeSet<LottoNumber> castTreeSet(String sLottoNumbers) throws LottoNumberFormatException {
        TreeSet<LottoNumber> set;
        try {
            set = addLottoNumber(sLottoNumbers);
        } catch (NumberFormatException exception) {
            throw new LottoNumberFormatException();
        }
        return set;
    }

    private static void validateLottoCount(TreeSet<LottoNumber> set) throws IllegalLottoCountException {
        if (set.size() != Lotto.LOTTO_COUNT) {
            throw new IllegalLottoCountException();
        }
    }

    private static TreeSet<LottoNumber> addLottoNumber(String sLottoNumbers)
            throws LottoNumberFormatException, LottoNumberOutOfBoundsException {

        String[] splitNumbers = sLottoNumbers.split(",");
        TreeSet<LottoNumber> set = new TreeSet<>();
        try {
            for (String sNumber : splitNumbers) {
                set.add(LottoNumber.valueOf(Integer.valueOf(sNumber.trim())));
            }
        } catch (NumberFormatException exception) {
            throw new LottoNumberFormatException();
        }

        return set;
    }

    private void validate() throws IllegalLottoCountException {
        if (lottoNumbers.size() != LOTTO_COUNT) {
            throw new IllegalLottoCountException(lottoNumbers.toString());
        }
    }

    public TreeSet<LottoNumber> numbers() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Lotto)) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
