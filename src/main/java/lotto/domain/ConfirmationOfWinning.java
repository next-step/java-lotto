package lotto.domain;

import java.util.List;

public class ConfirmationOfWinning {

    private ConfirmationOfWinning() {
    }

    public static int getRank(Lotto winningLotto, Lotto buyingLotto) {
        int containCount = getContainCount(winningLotto, buyingLotto);

        switch (containCount) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            default:
                return 5;
        }
    }

    private static int getContainCount(Lotto winningLotto, Lotto buyingLotto) {
        List<Integer> winningNumbers = winningLotto.getNumbers();
        int containCount = 0;
        for (Integer winningNumber : winningNumbers) {
            containCount += isContain(winningNumber, buyingLotto.getNumbers());
        }

        return containCount;
    }

    private static int isContain(Integer winningNumber, List<Integer> numbers) {
        if (numbers.contains(winningNumber)) {
            return 1;
        }
        return 0;
    }

}

