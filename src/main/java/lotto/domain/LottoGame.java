package lotto.domain;

import lotto.exception.InvalidLottoGame;

import java.util.*;

public class LottoGame {
    public static final int PRICE = 1_000;
    public static final int LOTTO_NUMBER_COUNT = 6;

    private Set<LottoNumber> lottoNumbers = new HashSet<>();

    public LottoGame() {
        fillRandomNumbers();
    }

    public LottoGame(int... numbers) {
        if (numbers.length > LOTTO_NUMBER_COUNT) {
            throw new InvalidLottoGame(String.format("%s %s",InvalidLottoGame.INVALID_LOTTO_GAME,lottoNumbers.size()));
        }

        for (int number : numbers) {
            addRandomNumber(number);
        }
    }

    private void addRandomNumber(int number) {
        lottoNumbers.add(new LottoNumber(new CustomNumber(number)));
    }

    private void fillRandomNumbers() {
        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            addRandomNumber();
        }
    }

    private void addRandomNumber() {
        LottoNumber number = new LottoNumber(new RandomNumber());
        while (lottoNumbers.contains(number)) {
            number = new LottoNumber(new RandomNumber());
        }
        lottoNumbers.add(number);
    }

    public boolean isValid() {
        if (this.lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new InvalidLottoGame(String.format("%s %s",InvalidLottoGame.INVALID_LOTTO_GAME,lottoNumbers.size()));
        }
        return true;
    }

    public int matchCount(LottoGame game2) {
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
