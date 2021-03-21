package study.step2.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private List<Lotto> lottos;
    private List<Integer> winNumbers;

    public LottoMachine() {
        lottos = new ArrayList<>();
        winNumbers = new ArrayList<>();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int purchase(int amount) {
        int count = getLottoCount(amount);
        for(int i=0; i<count; i++) {
            lottos.add(LottoFactory.createLotto());
        }
        return lottos.size();
    }

    private int getLottoCount(int amount) {
        return amount / LOTTO_PRICE;
    }

    public void setWinNumbers(String winInput) {
        winNumbers = Arrays.stream(winInput.split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
