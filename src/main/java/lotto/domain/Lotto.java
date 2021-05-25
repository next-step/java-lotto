package lotto.domain;

import lotto.exception.InvalidLottoGame;

import java.util.*;

public class Lotto {
    public static final int PRICE = 1_000;
    public static final int NUMBER_COUNT = 6;

    private Set<LottoNumber> lottoNumbers = new HashSet<>();

    public Lotto() {
        fillRandomNumbers();
    }

    public Lotto(int... numbers) {
        if (numbers.length != NUMBER_COUNT) {
            throw new InvalidLottoGame(String.format("%s %s",InvalidLottoGame.INVALID_LOTTO_GAME,numbers.length));
        }

        for (int number : numbers) {
            addCustomNumber(number);
        }
    }

    private void addCustomNumber(int number) {
        lottoNumbers.add(new LottoNumber(new CustomNumber(number)));
    }

    private void fillRandomNumbers() {
        for (int i = 0; i < NUMBER_COUNT; i++) {
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

    public Rank matchCount(Lotto other) {
        int count = 0;
        for (LottoNumber number : lottoNumbers) {
            count = other.increaseCountIfContains(number,count);
        }
        return Rank.of(count);
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
