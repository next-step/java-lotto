package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {

    public static final int LOTTO_PRICE = 1000;
    private List<Lotto> lottos = new ArrayList<>();
    private Lotto winningLotto;

    public void buyLotto(int price) {
        int gameCount = getGameCount(price);
        while(countLotto() < gameCount) {
            Lotto lotto = new Lotto(makingLottoNumbers());
            lottos.add(lotto);
        }
    }

    private List<Integer> makingLottoNumbers() {
        List<Integer> list = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
        Collections.shuffle(list);
        return list.subList(0, 6);
    }

    private int getGameCount(int price) {
        if (isValidBuyLottoPrice(price)) {
            throw new IllegalArgumentException();
        }
        return price /1000;
    }

    private  boolean isValidBuyLottoPrice(int price) {
        return price % LOTTO_PRICE != 0;
    }

    public int countLotto() {
        return lottos.size();
    }

    public void registerWinningLotto(List<Integer> numbers) {
        this.winningLotto = new Lotto(numbers);
    }

    public Lotto winningLotto() {
        return winningLotto;
    }
}
