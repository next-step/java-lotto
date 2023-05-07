package lotto.domain;

public class MyLotto {
    private final Numbers numbers;

    public MyLotto(Numbers numbers) {
        this.numbers = numbers;
    }

    public static MyLotto auto() {
        Numbers autoNumbers = Numbers.auto();
        return new MyLotto(autoNumbers);
    }

    public Numbers numbers() {
        return numbers;
    }

    public int checkMatchingNumbers(WinLotto winLotto) {
        int result = 0;
        for (int i = 0; i < LottoRule.CHOICE_COUNT; i++) {
            result += checkMatchingNumber(winLotto.findNumber(i));
        }
       return result;
    }

    private int checkMatchingNumber(Integer winNumber) {
        if (numbers.contains(winNumber)) {
            return 1;
        }
        return 0;
    }
}
