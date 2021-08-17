package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class WinningLotto {

    public static final String FIRST = "FIRST";
    public static final String SECOND = "SECOND";
    public static final String THIRD = "THIRD";
    public static final String FOURTH = "FOURTH";
    public static final String FIFTH = "FIFTH";
    public static final String MISS = "MISS";

    public static final long FIRST_EARN_MONEY = 2000000000;
    public static final long SECOND_EARN_MONEY = 1500000;
    public static final long THIRD_EARN_MONEY = 50000;
    public static final long FOURTH_EARN_MONEY = 5000;

    public static final int FOURTH_MATCH = 3;
    public static final int THIRD_MATCH = 4;
    public static final int SECOND_MATCH = 5;
    public static final int FIRST_MATCH = 6;

    public static final List<String> winStatus = Arrays.asList(
            WinningLotto.FOURTH, WinningLotto.THIRD
            ,WinningLotto.SECOND, WinningLotto.FIRST
    );

    private long earnMoney;
    private String lottoStatus;
    private int matchCount;

    public WinningLotto() {
        earnMoney = 0;
        matchCount = 0;
        lottoStatus = MISS;
    }

    public long getEarnMoney() {
        return earnMoney;
    }

    public String getLottoStatus() {
        return lottoStatus;
    }

    public void compareLottoNumber(List<Integer> lottoNumber, Integer winNumber) {
        if (lottoNumber.contains(winNumber)) {
            matchCount++;
        }
    }

    public void updateLottoStatus() {

        if (matchCount == FOURTH_MATCH) {
            lottoStatusEarnMoney(FOURTH, FOURTH_EARN_MONEY);
        }

        if (matchCount == THIRD_MATCH) {
            lottoStatusEarnMoney(THIRD, THIRD_EARN_MONEY);
        }

        if (matchCount == SECOND_MATCH) {
            lottoStatusEarnMoney(SECOND, SECOND_EARN_MONEY);
        }

        if (matchCount == FIRST_MATCH) {
            lottoStatusEarnMoney(FIRST, FIRST_EARN_MONEY);
        }

    }

    private void lottoStatusEarnMoney(String status, long money) {
        lottoStatus = status;
        earnMoney = money;
    }

    public boolean isLottoStatus(String status) {
        return lottoStatus.equals(status);
    }

}
