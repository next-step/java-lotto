package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {
    public static final int LOTTO_NUMBER_COUNT = 45;
    public static final int LOTTO_PICK_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers() {
        this.lottoNumbers = initLottoNumbers();
    }

    public LottoNumbers(final List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int size() {
        return lottoNumbers.size();
    }

    public boolean contains(final LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public boolean isMatch(final LottoNumbers numbers) {
        return lottoNumbers.stream().allMatch(numbers::contains);
    }

    public long matchCount(final LottoNumbers numbers) {
        return lottoNumbers.stream()
            .filter(numbers::contains)
            .count();
    }

    public LottoNumbers shuffleAndPickLottoNumbers() {
        final List<LottoNumber> pickedNumbers = pickLottoNumbers(shuffle());
        Collections.sort(pickedNumbers);
        return new LottoNumbers(pickedNumbers);
    }

    private static List<LottoNumber> pickLottoNumbers(final List<LottoNumber> shuffledLottoNumbers) {
        return shuffledLottoNumbers.subList(0, LOTTO_PICK_COUNT);
    }

    private List<LottoNumber> shuffle() {
        final List<LottoNumber> shuffledLottoNumbers = new ArrayList<>(lottoNumbers);
        Collections.shuffle(shuffledLottoNumbers);
        return shuffledLottoNumbers;
    }

    private List<LottoNumber> initLottoNumbers() {
        final List<LottoNumber> lottoNumbers = new ArrayList<>(LOTTO_NUMBER_COUNT);
        for (int i = 1; i <= LOTTO_NUMBER_COUNT; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }

        return Collections.unmodifiableList(lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
