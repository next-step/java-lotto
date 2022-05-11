package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private Numbers numbers;
    private Integer bonusNumber;

    public WinningNumbers(List<Integer> numbers, Integer bonusNumber) {
        this.numbers = new Numbers(numbers);
        this.bonusNumber = bonusNumber;
    }

    public Rank findRank(Lotto lotto) {
        // 일급 컬렉터간에 비교를 하게 되면 다시 또 lotto에서는 Numbers 입급컬렉터를 가져와야하는데
        // 이런 부분은 제가 잘못 설계를 한거 같은데 어떤식으로 보통 풀어가나요?
        // numbers.matchCount(lotto);

        // 이런식으로 객체를 가져오는 방식보다는 메세지를 보내라고 배웠는데
        // 마땅한 방법이 잘 떠오르지 않네요..ㅠㅠ 애초에 설계가 잘못된걸까요?
        List<Integer> lottoNumbers = lotto.getNumbers();
        return Rank.of(this.numbers.matchCount(lottoNumbers), checkingBonus(lottoNumbers));
    }

    private boolean checkingBonus(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }
}
