package lotto.domain;

import calculator.domain.Calculator;
import calculator.domain.Expression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.Game.PRICE;

public class Games {

    private final List<Game> games;

    public Games(String money, RandomNumberGenerator generator) {
        int numberOfGames = calculateNumberOfGames(money);

        List<Game> games = new ArrayList<>();
        for (int i = 0; i < numberOfGames; i++) {
            List<Integer> randomNumbers = generator.generate(Game.NUMBER_OF_LOTTONUMBER, Lottonumber.MIN, Lottonumber.MAX);
            games.add(new Game(randomNumbers));
        }

        if (games.isEmpty()) {
            throw new IllegalArgumentException(String.format("최소 %d원이 필요합니다.", PRICE));
        }

        this.games = Collections.unmodifiableList(games);
    }

    private static int calculateNumberOfGames(String money) {
        int numberOfGames;
        try {
            Expression expression = new Expression(money + " / " + PRICE);
            numberOfGames = Calculator.calculate(expression);

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("구매 금액은 숫자만 입력 가능합니다.");
        }
        return numberOfGames;
    }

    public List<Game> getGames() {
        return games;
    }
}
