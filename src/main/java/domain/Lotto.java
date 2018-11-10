package domain;

import utils.LottoGenerator;

import java.util.List;

public class Lotto {
    private static final int LOTTO_CHOICE_CNT = 6;

    private List<Integer> numbers;

    public Lotto() {
        numbers = LottoGenerator.generateNumberList(LOTTO_CHOICE_CNT);
    }

    public Lotto(int number) {
        numbers = LottoGenerator.generateNumberList(number);
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getCombineCount(Lotto lastLotto) {
        if (lastLotto == null) {
            return 0;
        }
        return (int) numbers.stream().filter(obj -> lastLotto.isContains(obj)).count();
    }

    private boolean isContains(Integer number) {
        return numbers.contains(number);
    }

    public void printLotto() {
        System.out.println(this.numbers);
    }

}
