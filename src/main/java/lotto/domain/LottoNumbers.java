package lotto.domain;

import lotto.exception.SameNumberException;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoNumbers {

    private static final int LOTTO_LENGTH = 6;
    private static final int MAXIMUM_VALUE = 1;

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

        checkSameNumber(manualNumbers, lottoNumbers);

        return new LottoNumbers(lottoNumbers);
    }

    private static void checkSameNumber(List<String> manualNumbers, Set<LottoNumber> lottoNumbers) {
        if (manualNumbers.size() != lottoNumbers.size()) {
            List<String> sameNumber = findSameNumber(manualNumbers);
            throw new SameNumberException(sameNumber);
        }
    }

    private static List<String> findSameNumber(List<String> manualNumbers) {
        Map<String, Long> countMap = manualNumbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return countMap.entrySet().stream()
                .filter(LottoNumbers::hasSameNumber)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private static boolean hasSameNumber(Map.Entry<String, Long> key) {
        return key.getValue() > MAXIMUM_VALUE;
    }

    public int findMatchingNumbers(LottoNumbers winningNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers::hasMatchingNumber)
                .count();
    }

    private boolean hasMatchingNumber(LottoNumber winningNumber) {
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
