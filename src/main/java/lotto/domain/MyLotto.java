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

    public static MyLotto manual(String inputString) {
        Numbers manualNumbers = new Numbers(inputString);
        return new MyLotto(manualNumbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public Numbers numbers() {
        return numbers;
    }

    public void checkMatchingNumbers(WinLotto winLotto) {
        for (int i = 0; i < LottoRule.CHOICE_COUNT; i++) {
            checkMatchingNumber(winLotto.findNumber(i));
        }
    }

    private void checkMatchingNumber(Integer winNumber) {
        if (numbers.contains(winNumber)) {
            matchingCount++;
        }
    }

    public int matchingCount() {
        return matchingCount;
    }
}
