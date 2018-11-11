package domain;

import utils.LottoGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_CHOICE_CNT = 6;

    private List<Integer> numbers;
    private Integer bonusNumber;

    public Lotto() {
        this(LottoGenerator.generateNumberList(LOTTO_CHOICE_CNT));

    }

    public Lotto(int number) {
        this(LottoGenerator.generateNumberList(number));
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

    public int getNumCount() {
        return numbers.size();
    }

    public WinningLotto getCombineNumbers(Lotto lotto) {
        List<Integer> combineNumbers = numbers.stream().
                filter(obj -> lotto.getNumbers().contains(obj))
                .collect(Collectors.toList());

        boolean isBonus = isContains(lotto.getBonusNum());
        return new WinningLotto(combineNumbers, isBonus);
    }

    private Integer getBonusNum() {
        return bonusNumber;
    }

    public void addNumber(Integer bonusNum) {
        bonusNumber = bonusNum;
    }
}
