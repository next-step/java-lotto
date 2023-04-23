package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LottoNumbers {

    public static final int LOTTO_LENGTH = 6;

    private final Set<LottoNumber> lottoNumbers;

    public LottoNumbers(Set<LottoNumber> lottoNumbers) {
        checkLottoNumberLength(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void checkLottoNumberLength(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("로또 숫자는 6개를 입력해주세요!");
        }
    }

    public static LottoNumbers initShuffledLottoNumbers() {
        Set<LottoNumber> lottoNumbers = new TreeSet<>();
        while (lottoNumbers.size() < LOTTO_LENGTH) {
            LottoNumber lottoNumber = LottoNumber.createLottoNumber();
            lottoNumbers.add(lottoNumber);
        }

        return new LottoNumbers(lottoNumbers);
    }

    public static LottoNumbers initManualLottoNumbers(List<String> manualNumbers) {
        Set<LottoNumber> lottoNumbers = manualNumbers.stream()
                .map(LottoNumber::createManualLottoNumber)
                .collect(Collectors.toCollection(TreeSet::new));

        checkSameNumber(manualNumbers.size(), lottoNumbers.size());

        return new LottoNumbers(lottoNumbers);
    }

    private static void checkSameNumber(int manualSize, int lottoSize) {
        if (manualSize != lottoSize) {
            throw new IllegalArgumentException("같은 숫자를 입력했습니다.");
        }
    }

    public int findSameNumbers(LottoNumbers winningNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers::hasSameNumber)
                .count();
    }

    private boolean hasSameNumber(LottoNumber winningNumber) {
        return lottoNumbers.contains(winningNumber);
    }

    public int getLottoNumberSize() {
        return lottoNumbers.size();
    }

    @Override
    public String toString() {
        return "" + lottoNumbers;
    }
}
