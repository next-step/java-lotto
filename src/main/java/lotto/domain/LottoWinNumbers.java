package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.LottoGameOptions.*;
import static lotto.domain.LottoRank.MAP_LOTTO_RESULT;

public class LottoWinNumbers {
    private List<Integer> winNumbers = new ArrayList<>();
    private int bonusNumber = 0;

    public LottoWinNumbers(String numbers) {
        initWinNumbers(numbers.split(", |,"));
    }

    private void initWinNumbers(String[] winNums) {
        if (invalid(winNums)) {
            throw new IllegalArgumentException();
        }

        for (String num : winNums) {
            addWinNumber(Integer.parseInt(num));
        }
    }

    private boolean invalid(String[] winNums) {
        return winNums.length != LOTTO_NUMBER_COUNT;
    }

    private void addWinNumber(int num) {
        if (num < LOTTO_NUMBERS_FROM || num > LOTTO_NUMBERS_TO) {
            throw new IllegalArgumentException();
        }
        winNumbers.add(num);
    }

    public LottoResultPack checkAllOf(Lottos lottos) {
        LottoResultPack resultPack = new LottoResultPack();

        for (Lotto lotto : lottos.values()) {
            resultPack.put(matchResultOf(lotto));
        }

        return resultPack;
    }

    protected LottoRank matchResultOf(Lotto lotto) {
        int matchCount = 0;
        boolean matchBonus = false;
        for (int i = 0; i < LOTTO_NUMBER_COUNT; ++i) {
            for (int j = 0; j < LOTTO_NUMBER_COUNT; ++j) {
                if (winNumbers.get(i) == lotto.numbers(j)) {
                    ++matchCount;
                }
                if (this.bonusNumber == lotto.numbers(j)) {
                    matchBonus = true;
                }
            }
//            final int index = i;
//            matchCount += winNumbers.stream()
//                                    .filter(n -> n == lotto.numbers(index))
//                                    .count();
        }

        return LottoRank.valueOf(matchCount, matchBonus);

//        return measureLucky(matchCount);
    }

    private LottoRank measureLucky(int matchCount) {
        return MAP_LOTTO_RESULT.get(matchCount);
    }

    public void addBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
