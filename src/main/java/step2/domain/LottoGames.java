package step2.domain;

import java.util.*;
import java.util.stream.IntStream;

public class LottoGames {
    private static final int DEFAULT_NUMBER_COUNT = 6;
    private static int DEFAULT_LOTTO_PRICE = 1000;
    private static final int MINIMUM_MATH_COUNT = 3;
    private static final int MAXIMUM_MATH_COUNT_EXCLUSIVE = 7;

    public LottoGames() {
    }

    public int howManyBuyGames(int money) {
        Objects.requireNonNull(money);
        return new Integer(money / DEFAULT_LOTTO_PRICE);
    }

    public List<LottoGame> buyLottoGame(int gameCount) {
        List<LottoGame> lottoGames = new ArrayList<>(gameCount);
        for (int i = 0; i < gameCount; i++) {
            lottoGames.add(createLottoGame());
        }
        return lottoGames;
    }

    private LottoGame createLottoGame() {
        return new LottoGame(RandomIntegersGenerator.createNumberList());
    }

    public LottoGame readWinningNumber(String stringNumber) {
        String[] numbers = splitByDelimiter(stringNumber);
        Set<Integer> integers = toSet(numbers);
        if (integers.size() != DEFAULT_NUMBER_COUNT) {
            throw new IllegalArgumentException(stringNumber + " : 입력한 숫자를 확인해 주세요");
        }
        return new LottoGame(integers);
    }

    private String[] splitByDelimiter(String stringNumber) {
        stringNumber = stringNumber.replaceAll(" ", "");
        return stringNumber.split(",");
    }

    private Set<Integer> toSet(String[] numbers) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (String number : numbers) {
            hashSet.add(toInt(number));
        }
        return hashSet;
    }

    private Integer toInt(String element) {
        try {
            return Integer.parseInt(element);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(element + " : 유효한 정수 값이 아닙니다.");
        }
    }
}
