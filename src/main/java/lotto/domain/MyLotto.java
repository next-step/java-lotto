package lotto.domain;

public class MyLotto {
    private final Numbers numbers;
    private int matchingCount;

    public MyLotto(Numbers numbers) {
        this.numbers = numbers;
        this.matchingCount = 0;
    }

    public static MyLotto auto() {
        Numbers autoNumbers = Numbers.auto();
        return new MyLotto(autoNumbers);
    }

    public Numbers numbers() {
        return numbers;
    }

    public void checkMatchingNumbers(WinLotto winLotto) {
        int result = 0;
        for (int i = 0; i < LottoRule.CHOICE_COUNT; i++) {
            result += checkMatchingNumber(winLotto.findNumber(i));
        }
        matchingCount = result;
    }

    private int checkMatchingNumber(Integer winNumber) {
        if (numbers.contains(winNumber)) {
            return 1;
        }
        return 0;
    }

    public int matchingCount() {
        return matchingCount;
    }
}
