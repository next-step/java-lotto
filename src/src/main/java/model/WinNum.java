package model;

import java.util.ArrayList;
import java.util.List;

public class WinNum {
    private static final int LOTTO_NUMS = 6;
    private static final String LOTTO_COUNT_ERORR_MESSAGE = "로또의 개수가 " + LOTTO_NUMS + "개가 아닙니다.";
    private List<LottoNumber> winNum = new ArrayList<>();
    private LottoNumber bonus;

    public WinNum(List<Integer> winnerNums, int bonus) {
        for (int num : winnerNums) {
            this.winNum.add(new LottoNumber(num));
        }
        isValidLottoCount(this.winNum);
        this.bonus = new LottoNumber(bonus);
    }

    public List<LottoNumber> getWinNum() {
        return this.winNum;
    }

    public boolean matchBonus(Lotto lotto) {
        return lotto.contains(this.bonus);
    }

    public int matchCount(Lotto lotto) {
        return (int) winNum.stream()
                .filter(lotto::contains)
                .count();
    }

    private static void isValidLottoCount(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMS) {
            throw new RuntimeException(LOTTO_COUNT_ERORR_MESSAGE);
        }
    }
}
