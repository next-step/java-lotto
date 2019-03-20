package application;

import domain.Lotto;
import domain.Number;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class LottoGame {
    private List<Lotto> lottos = new ArrayList();

    public LottoGame(int price) {
        IntStream.range(0, getCount(price)).boxed()
                .forEach(v -> lottos.add(new Lotto(new Random())));
    }

    private int getCount(int price) {
        return price / 1000;
    }

    public int getSize() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void run(List<Number> numbers) {

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
}
