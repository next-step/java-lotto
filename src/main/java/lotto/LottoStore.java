package lotto;


import java.util.List;

public class LottoStore {

    private final int LOTTO_PRICE = 1000;
    public int getLottoNum(int input) {
        return input / LOTTO_PRICE;
    }

    public Lotto getLotto() {
        return new Lotto();
    }

    public Lotto getLotto(List<Integer> lottoNum) {
        return new Lotto(lottoNum);
    }

    public long getMatchedCount(Lotto lotto, List<Integer> input) {
        List<Integer> x = lotto.getLotto();
        return input.stream().filter((num)->x.contains(num)).count();

    }
}