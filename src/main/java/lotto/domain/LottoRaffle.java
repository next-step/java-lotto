package lotto.domain;

import java.util.*;

import static lotto.domain.LottoNumber.shuffleNumbers;

public class LottoRaffle {

    private final static int LOTTO_MAX_BALL = 6;
    private final TreeSet<Integer> raffleNumbers;

    public LottoRaffle() {
        this.raffleNumbers = new TreeSet<>();
    }

    public NavigableSet<Integer> raffleNumbers() {
        pop(new ArrayList<>(shuffleNumbers()));
        return Collections.unmodifiableNavigableSet(raffleNumbers);
    }

    private void pop(List<Integer> lottoNumbers) {
        if (raffleNumbers.size() == LOTTO_MAX_BALL) {
            return;
        }
        raffleNumbers.add(lottoNumbers.remove(lottoNumbers.size() - 1));
        pop(lottoNumbers);
    }
}
