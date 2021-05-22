package lotto.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static lotto.domain.LottoGameOptions.*;

public class LottoWinNumbers {
    private List<Integer> winNumbers = new ArrayList<>();

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

        Iterator<Lotto> it = lottos.iterator();
        while (it.hasNext()) {
            resultPack.put(matchResultOf(it.next()));
        }

        return resultPack;
    }

    protected LottoResult matchResultOf(Lotto lotto) {
        int match = 0;

        for (int i = 0; i < LOTTO_NUMBER_COUNT; ++i) {
            final int index = i;
            match += winNumbers.stream().filter(n -> n == lotto.numbers(index)).count();
        }

        return measureLucky(match);
    }

    private LottoResult measureLucky(int count) {
        return MAP_LOTTO_RESULT.get(count);
    }

}
