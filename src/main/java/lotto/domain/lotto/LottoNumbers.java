package lotto.domain.lotto;

import java.util.*;

public class LottoNumbers {
    public static final int LOTTO_NUMBER_SIZE = 6;
    private static final NumberGenerator NUMBER_GENERATOR = NumberGenerator.create();
    private List<LottoNumber> lottoLottoNumbers;

    private LottoNumbers(List<LottoNumber> lottoLottoNumbers) {
        checkSize(lottoLottoNumbers);
        checkDuplicate(lottoLottoNumbers);
        this.lottoLottoNumbers = lottoLottoNumbers;
    }

    public static LottoNumbers create() {
        List<LottoNumber> lottoLottoNumbers = NUMBER_GENERATOR.createLottoNumbers();
        return new LottoNumbers(lottoLottoNumbers);
    }

    public static LottoNumbers create(List<LottoNumber> lottoLottoNumbers) {
        return new LottoNumbers(lottoLottoNumbers);
    }

    public List<LottoNumber> getLottoLottoNumbers() {
        return Collections.unmodifiableList(lottoLottoNumbers);
    }

    public int findMatchCount(LottoNumbers winningNumbers) {
        return (int) winningNumbers.getLottoLottoNumbers().stream()
                .filter(lottoNumber ->  lottoLottoNumbers.contains(lottoNumber))
                .count();
    }

    public boolean haveBonusBall(LottoNumber bonusBall) {
        for (LottoNumber lottoNumber : lottoLottoNumbers) {
            if (lottoNumber.equals(bonusBall))
                return true;
        }
        return false;
    }

    private void checkSize(List<LottoNumber> lottoLottoNumbers) {
        if (lottoLottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_NUMBER_SIZE + "개 입니다");
        }
    }

    private void checkDuplicate(List<LottoNumber> lottoLottoNumbers) {
        Set<LottoNumber> lottoLottoNumberSet = new HashSet<>(lottoLottoNumbers);
        if (lottoLottoNumberSet.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("중복된 로또 번호가 존재 합니다");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoLottoNumbers, that.lottoLottoNumbers);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoLottoNumbers);
    }


}
