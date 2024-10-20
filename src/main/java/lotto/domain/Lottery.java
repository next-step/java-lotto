package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Lottery {
    private static final String DELIMITER = ", ";

    private final Set<Integer> lottoNumbers;

    public static Lottery from(String inputLottoNumbers) {
        Set<Integer> lottoNumbers = Arrays.stream(inputLottoNumbers.split(DELIMITER))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toSet());

        return new Lottery(lottoNumbers);
    }

    public Lottery(Set<Integer> lottoNumbers) {
        LottoNumberValidator.validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public int countWinningNumbers(Lottery winningNumbers) {
        Set<Integer> equalNumbers = new HashSet<>(this.lottoNumbers);
        equalNumbers.retainAll(winningNumbers.lottoNumbers);

        return equalNumbers.size();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    public LottoResult createLottoResult(Lottery winningNumbers, BonusNumber bonusNumber) {
        int equalNumberCount = countWinningNumbers(winningNumbers);
        boolean hasBonusNumber = hasBonusNumber(bonusNumber.getBonusNumber());

        return new LottoResult(hasBonusNumber, equalNumberCount);
    }

    private boolean hasBonusNumber(int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }
}
