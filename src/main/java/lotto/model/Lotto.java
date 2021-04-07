package lotto.model;

import lotto.exception.LottoNumbersSizeOverException;
import lotto.exception.NumberAlreadyExistsException;
import lotto.util.RandomIntUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private List<Number> numbers;


    public Lotto(List<Number> numbers) {
        this.numbers = numbers;
        Collections.sort(numbers);
    }

    public Lotto() {
        this.numbers = new ArrayList<>();
    }

    public Lotto(String[] numbers) {
        this.numbers = new ArrayList<>();
        for (String number : numbers) {
            addNumber(new Number(number.trim()));
        }
    }

    public void addNumber(Number number) {
        if (numbers.contains(number)) {
            throw new NumberAlreadyExistsException("Number already exists.");
        }
        if (numbers.size() >= 6) {
            throw new LottoNumbersSizeOverException("Numbers can contain 6 numbers.");
        }
        numbers.add(number);
        Collections.sort(numbers);
    }

    public boolean contain(Number number) {
        return numbers.contains(number);
    }

    public void createRandomNumber() {
        while (numbers.size() < 6) {
            Number number = new Number(RandomIntUtil.getRandomInt());
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        Collections.sort(numbers);
    }

    @Override
    public String toString() {
        return "[" + numbers.stream().map(String::valueOf).collect(Collectors.joining(",")) + ']';
    }

    public LottoPrize getPrize(Lotto winLotto) {
        int matchs = 0;
        for (Number number : numbers) {
            if (winLotto.numbers.contains(number)) {
                matchs++;
            }

        }
        return LottoPrize.getByMathes(matchs);
    }
}
