package lotto.domain;

public class ConfirmationOfWinning {

    private static final int FAIL_RANK = 5;

    private ConfirmationOfWinning() {
    }

    public static int getRank(Lotto winningLotto, Lotto buyingLotto) {
        int containCount = getContainCount(winningLotto, buyingLotto);

        if(containCount >= 3) {
            return 6 - containCount + 1;
        }

        return FAIL_RANK;
    }

    private static int getContainCount(Lotto winningLotto, Lotto buyingLotto) {
        return (int) buyingLotto.getNumbers().stream()
                .filter(lottoNumber -> winningLotto.getNumbers().contains(lottoNumber))
                .count();
    }
}

