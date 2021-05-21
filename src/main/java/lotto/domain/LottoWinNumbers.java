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
        if (winNums.length != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }

        for (String num : winNums) {
            addWinNumber(Integer.parseInt(num));
        }
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

    public LottoResult matchResultOf(Lotto lotto) {
        int match = 0;

        for (int i = 0; i < LOTTO_NUMBER_COUNT; ++i) {
            match += countIfWinNumContains(lotto.numbers(i));
        }

        return measureLucky(match);
    }

    private int countIfWinNumContains(int number) {
        if (winNumbers.contains(number)) {
            return 1;
        }
        return 0;
    }

    private LottoResult measureLucky(int count) {
        return LottoResult.valueOf(LottoResult.MATCH_.toString() + count);
    }

}
