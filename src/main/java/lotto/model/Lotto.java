package lotto.model;

import lotto.exception.LottoNumbersSizeException;
import lotto.exception.NumberAlreadyExistsException;
import lotto.util.RandomIntUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    public final static String DELIMITER = ",";
    private final static int WINNING_NUMBER_COUNTS = 6;
    private List<Number> numbers;

    public Lotto() {
        this.numbers = new ArrayList<>();
    }

    public Lotto(List<Number> randomNumbers) {
        this.numbers = randomNumbers;
    }

    public Lotto(String winningNumbers) {
        String[] numbers = winningNumbers.split(DELIMITER);
        if (numbers.length != 6) {
            throw new LottoNumbersSizeException("Please input 6 numbers.");
        }
        this.numbers = new ArrayList<>();
        for (String number : numbers) {
            addNumber(new Number(Integer.parseInt(number.trim())));
        }
    }

    public void addNumber(Number number) {
        if (numbers.contains(number)) {
            throw new NumberAlreadyExistsException("Number already exists.");
        }

        if (numbers.size() >= WINNING_NUMBER_COUNTS) {
            throw new LottoNumbersSizeException("Numbers can contain 6 numbers.");
        }
        numbers.add(number);
        Collections.sort(numbers);
    }

    public boolean contain(Number number) {
        return numbers.contains(number);
    }


    public LottoPrize getPrize(Lotto winLotto, Number bonusNumber) {
        int matchs = 0;
        for (Number number : numbers) {
            if (winLotto.numbers.contains(number)) {
                matchs++;
            }
        }

        return LottoPrize.checkWithMatchsAndBonusMatch(matchs, numbers.contains(bonusNumber));
    }

    public List<Number> getNumbers() {
        return numbers;
    }
}

