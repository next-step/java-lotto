package lotto.model;

import lotto.utility.Validator;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class WinningLotto {
    private static final int[] RANK_BY_MATCH_COUNT = {0, 0, 0, 5, 4, 3, 1};

    private List<LottoNumber> numbers;
    private LottoNumber bonusNumber;

    public WinningLotto(String winningNumbers, int bonusNumber) {
        Validator.isValidBonusNumber(winningNumbers, bonusNumber);

        this.numbers = parseWinningNumbers(winningNumbers).stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    private List<Integer> parseWinningNumbers(String winningNumber) {
        return stream(winningNumber.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int determineRank(BoughtLotto boughtLotto) {
        int matchCount = countMatchNumbers(boughtLotto.getNumbers());
        boolean isMatchBonus = checkBoughtLottoMatchBonusNumber(boughtLotto.getNumbers());

        if(matchCount == 5 && isMatchBonus) {
            return 2;
        }

        return RANK_BY_MATCH_COUNT[matchCount];
    }

    private int countMatchNumbers(List<LottoNumber> boughtLottoNumbers) {
        return (int) boughtLottoNumbers.stream()
                .filter(number -> !number.equals(bonusNumber))
                .filter(this.numbers::contains)
                .count();
    }

    private boolean checkBoughtLottoMatchBonusNumber(List<LottoNumber> boughtLottoNumbers) {
        return boughtLottoNumbers.contains(bonusNumber);
    }

}
