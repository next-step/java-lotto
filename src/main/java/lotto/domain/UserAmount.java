package lotto.domain;

import java.util.List;

public class UserAmount {
    private static final String NOT_ALLOW_NEGATIVE_MESSAGE = "금액은 음수일 수 없습니다.";
    private static final int MIN_USER_AMOUNT = 0;

    private final int userAmount;

    public UserAmount(int userAmount) {
        if (userAmount < MIN_USER_AMOUNT) {
            throw new IllegalArgumentException(NOT_ALLOW_NEGATIVE_MESSAGE);
        }

        this.userAmount = userAmount;
    }

    public double calculateRevenue(int sum) {
        return sum / this.userAmount;
    }

    public int getRandomLottoSize(int lottoPrice, List<LottoNumbers> userInputLottos) {
        return getRandomLottoSize(lottoPrice, userInputLottos.size());
    }

    int getRandomLottoSize(int lottoPrice, int userInputLottosSize) {
        return (this.userAmount / lottoPrice) - userInputLottosSize;
    }

}
