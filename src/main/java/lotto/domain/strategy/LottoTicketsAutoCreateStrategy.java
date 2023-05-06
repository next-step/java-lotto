package lotto.domain.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicketsAutoCreateStrategy implements LottoTicketsCreateStrategy {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private int buyAutomaticCount;

    public LottoTicketsAutoCreateStrategy(int buyAutomaticCount) {
        this.buyAutomaticCount = buyAutomaticCount;
    }


    @Override
    public List<List<Integer>> getLottoNumbers() {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < buyAutomaticCount; i++) {
            lottoNumbers.add(autoCreate());
        }
        return lottoNumbers;
    }

    public List<Integer> autoCreate() {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            lottoNumbers.add(i);
        }
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(0, LOTTO_SIZE);
    }
}
