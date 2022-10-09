package step2.domian;

public class Counter {
    public static int countSameNumber(Lotto lotto, Lotto lastWinner) {
        int sameCount = 0;
        for (int num : lastWinner.numbers) {
            sameCount += isContain(lotto, num);
        }
        return sameCount;
    }

    private static int isContain(Lotto lotto, int num) {
        if (lotto.numbers.contains(num)) {
            return 1;
        }
        return 0;
    }
}
