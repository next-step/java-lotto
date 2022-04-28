package lottoauto.domain;

import java.util.List;

public class Lotto {
    public static final int PRICE = 1000;

    private List<Integer> numbers;
    private int matchCount;

    public Lotto(){
        this.numbers = LottoGenerator.makeLotto();
    }

    public Lotto(List<Integer> inputNumbers) {
        if(inputNumbers.size() > 6){
            throw new IllegalArgumentException("로또의 숫자는 6개 입니다.");
        }
        this.numbers = inputNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public void match(Lotto winnerLotto) {
        matchCount = 0;
        for (Integer number : winnerLotto.getNumbers()) {
            if(numbers.contains(number)) matchCount += 1;
        }
    }
}
