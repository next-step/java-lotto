package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private List<List<Integer>> lottoNumbers = new ArrayList<>();

    public Lotto(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            this.lottoNumbers.add(LottoNumberGenerator.getNumber());
        }
    }

    public List<List<Integer>> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public List<RewardLotto> getRewardLotto(String[] winningNumber, int bonus) {
        return lottoNumbers.stream()
                        .map(lottoNumber -> checkWinnerNumber(lottoNumber, winningNumber, bonus))
                        .collect(Collectors.toList());
    }

    private RewardLotto checkWinnerNumber(List<Integer> lottoNumber, String[] winningNumber, int bonus) {
        int matchingCount = 0;
        for (int i = 0; i < winningNumber.length; i++) {
            matchingCount += (lottoNumber.contains(Integer.parseInt(winningNumber[i]))) ? 1 : 0;
        }
        return new RewardLotto(matchingCount, lottoNumber.contains(bonus));
    }

}
