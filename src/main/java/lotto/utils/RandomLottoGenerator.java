package lotto.utils;

import lotto.domain.lotto.BasicLotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Ticket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoGenerator implements LottoGenerator {
    private static final int SELECT_MAX_COUNT = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private List<LottoNumber> allNumbers;

    public RandomLottoGenerator() {
        createAllNumbers();
    }

    @Override
    public BasicLotto generate() {
        List<LottoNumber> generatedNumbers = new ArrayList<>();
        Collections.shuffle(this.allNumbers);
        for (int i = 0; i < SELECT_MAX_COUNT; i++) {
            generatedNumbers.add(this.allNumbers.get(i));
        }
        Collections.sort(generatedNumbers);
        return new BasicLotto(new Ticket(generatedNumbers));
    }

    @Override
    public BasicLotto generate(Ticket ticket) {
        return new BasicLotto(ticket);
    }

    private void createAllNumbers() {
        this.allNumbers = new ArrayList<>();
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            this.allNumbers.add(new LottoNumber(i));
        }
    }
}
