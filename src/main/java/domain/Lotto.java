package domain;

import java.util.*;

public class Lotto {
    static final int LOTTOBALLS = 6;
    static final int LOTTORANGE = 45;

    private List<Integer> lotto;

    public Lotto() {
        this.lotto = new ArrayList<>();
        pickLottoNumbers();
    }

    public List<Integer> getLotto() {
        return this.lotto;
    }

    public void rangeOfLottoNumber() {
        for(int i = 1; i <= LOTTORANGE; i++) {
            this.lotto.add(i);
        }
    }

    public void shuffleNumbers() {
        Collections.shuffle(this.lotto);
    }

    public void fillLottoNumbers() {
        Set<Integer> set = new HashSet<>();

        while(set.size() < LOTTOBALLS) {
            set.add(this.lotto.get(set.size()));
        }

        this.lotto = new ArrayList<>(set);
        Collections.sort(this.lotto);
    }

    public void pickLottoNumbers() {
        rangeOfLottoNumber();
        shuffleNumbers();
        fillLottoNumbers();
    }

    public List<Integer> putLottoNumber() {
        return this.getLotto();
    }
}
