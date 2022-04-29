package lottoauto.domain;

import java.util.List;

public class Lotto {
    public static final int PRICE = 1000;

    private List<Integer> numbers;
    private int matchCount;
    private boolean matchThree = false;
    private boolean matchFour = false;
    private boolean matchFive = false;
    private boolean matchSix = false;

    public Lotto(){
        this.numbers = LottoGenerator.makeLotto();
        System.out.println(this.numbers);
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

    public boolean isMatchThree() {
        return matchThree;
    }

    public boolean isMatchFour() {
        return matchFour;
    }

    public boolean isMatchFive() {
        return matchFive;
    }

    public boolean isMatchSix() {
        return matchSix;
    }

    public void match(Lotto winnerLotto) {
        matchCount = 0;
        for (Integer number : winnerLotto.getNumbers()) {
            if(numbers.contains(number)) matchCount += 1;
        }
        if (matchCount == 3){
            matchThree = true;
        }
        if (matchCount == 4){
            matchFour = true;
        }
        if (matchCount == 5){
            matchFive = true;
        }
        if (matchCount == 6){
            matchSix = true;
        }
    }
}
