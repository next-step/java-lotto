package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.domain.LottoNumberGenerator.LOTTO_NUMBERS_SIZE;

public class Lottery {
    private final Set<LottoNumber> lottoNumbers;

    public Lottery(Set<Integer> lottoNumbers) {
        validateLottoNumberSize(lottoNumbers);

        this.lottoNumbers = lottoNumbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }

    public int countWinningNumbers(WinningLottery winningLottery) {
        Set<LottoNumber> equalNumbers = new HashSet<>(this.lottoNumbers);
        equalNumbers.retainAll(winningLottery.getWinningLottery().lottoNumbers);

        return equalNumbers.size();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    public List<Integer> getSortedLottoNumbers() {
        return lottoNumbers.stream()
                .map(LottoNumber::getLottoNumber)
                .sorted()
                .collect(Collectors.toList());
    }

    public LottoRank createLottoRank(WinningLottery winningLottery) {
        int equalNumberCount = countWinningNumbers(winningLottery);
        boolean hasBonusNumber = hasBonusNumber(winningLottery.getBonusNumber());

        return LottoRank.of(equalNumberCount, hasBonusNumber);
    }

    private void validateLottoNumberSize(Set<Integer> lottoNumbers) {
        if (lottoNumbers == null || lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(String.format("로또번호는 %d개 이어야 합니다", LOTTO_NUMBERS_SIZE));
        }
    }

    private boolean hasBonusNumber(LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }
}
