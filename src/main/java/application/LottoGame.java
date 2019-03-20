package application;

import domain.Lotto;
import domain.Winning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class LottoGame {
    private List<Lotto> lottos = new ArrayList();

    public LottoGame(int price, Random random) {
        IntStream.range(0, getCount(price)).boxed()
                .forEach(v -> lottos.add(new Lotto(random)));
    }

    private int getCount(int price) {
        return price / 1000;
    }

    public int getSize() {
        return lottos.size();
    }

    public List<Integer> run(Winning winning) {
        List<Integer> results = new ArrayList();
        lottos.stream().forEach(v -> results.add(winning.compare(v.getNumbers())));
        return results;
    }
}

enum LottoGameResult {
    THREE(3, "5000원"),
    FOUR(4, "50000원"),
    FIVE(5, "1500000원"),
    SIX(6, "2000000000원");

    private int value;
    private String reward;

    LottoGameResult(int value, String reward) {
        this.value = value;
        this.reward = reward;
    }

    public static LottoGameResult match(int number) {
        if(isInRange(number)) {
            throw new IllegalArgumentException("로또 게임 결과가 0 ~ 6 범위에서 벗어납니다.");
        }

        return Arrays.stream(LottoGameResult.values()).filter(v -> v.value == number).findFirst().get();
    }

    private static boolean isInRange(int number) {
        return number < 0 || number > 6;
    }

    public String getReward() {
        return reward;
    }
}
