package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {

    private static final int WINNING_NUMBER_SIZE = 7;
    private final List<LottoNumber> winningNumbers;

    public static WinningNumbers of(Lotto lotto, LottoNumber bonusNumber) {
        List<LottoNumber> lottoNumbers = new ArrayList<>(lotto.lottoNumbers());
        lottoNumbers.add(bonusNumber);
        return new WinningNumbers(lottoNumbers);
    }

    private WinningNumbers(List<LottoNumber> winningNumbers) {
        inputValidation(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void inputValidation(List<LottoNumber> lottoNumbers) {
        if(lottoNumbers.size() != WINNING_NUMBER_SIZE){
            throw new IllegalArgumentException("당첨 번호는 7개여야 합니다.");
        }

        if(lottoNumbers.stream().mapToInt(LottoNumber::number).distinct().count() != WINNING_NUMBER_SIZE){
            throw new IllegalArgumentException("당첨 번호는 중복될 수 없습니다.");
        }
    }

    public int matchCount(Lotto lotto) {
        return (int) winningNumbers.stream()
                .filter(lotto::contains)
                .count();
    }

    public boolean containBonus(Lotto lotto) {
        return winningNumbers.stream()
                .filter(lotto::contains)
                .anyMatch(LottoNumber::isBonus);

    }
}
