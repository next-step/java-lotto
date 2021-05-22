package lotto.domain;

import lotto.exception.InvalidLottoGame;
import lotto.util.MessageContainer;

import java.util.*;

public class LottoGame {
    public static final int PRICE = 1_000;
    public static final int LOTTO_NUMBER_COUNT = 6;

    private Set<LottoNumber> lottoNumbers = new HashSet<>();

    public LottoGame() {
        fillRandomNumbers();
    }

    public LottoGame(int... numbers) {
        // 수동 x 개
        for (int number : numbers) {
            addRandomNumber(number);
        }
        // 나머지 y 개
        fillRandomNumbers();
    }

    public static boolean isAffordable(int money) {
        return money >= PRICE;
    }

    private void addRandomNumber(int number) {
        lottoNumbers.add(new LottoNumber(new RandomNumber(number)));
    }

    private void fillRandomNumbers() {
        while(lottoNumbers.size() < LOTTO_NUMBER_COUNT) {
            addRandomNumber();
        }
        isValid();
    }

    private void addRandomNumber() {
        lottoNumbers.add(new LottoNumber(new RandomNumber()));
    }

    public boolean isValid() {
        if (this.lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new InvalidLottoGame(String.format("%s %s",MessageContainer.INVALID_LOTTO_GAME,lottoNumbers.size()));
        }
        return true;
    }

    public int getRank(LottoGame game2) {
        int count = 0;
        for (LottoNumber number : lottoNumbers) {
            count = game2.increaseCountIfContains(number,count);
        }
        return count;
    }

    private int increaseCountIfContains(LottoNumber number, int count) {
        if (containsNumber(number)) {
            return count + 1;
        }
        return count;
    }

    private boolean containsNumber(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    @Override
    public String toString() {
        List<LottoNumber> numbers = new ArrayList<LottoNumber>(lottoNumbers);
        Collections.sort(numbers);
        return numbers.toString();
    }
}
