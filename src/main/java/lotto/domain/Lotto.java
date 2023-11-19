package lotto.domain;

import java.util.*;

public class Lotto {
    private final List<Integer> lottoNumber;
    private int matchPoint;

    public Lotto() {
        this.matchPoint = 0;
        List<Integer> temp = new ArrayList<>();

        for (int i = 1; i <= 45; i++) {
            temp.add(i);
        }

        Collections.shuffle(temp);

        this.lottoNumber = temp.subList(0, 6);
        sort();
    }

    public Lotto(List<Integer> defaultLottoNumber) {
        this.lottoNumber = defaultLottoNumber;
        this.matchPoint = 0;
    }

    private void sort() {
        Collections.sort(this.lottoNumber);
    }

    public void compareWinningNumber(String[] winningNum) {
        for (String str : winningNum) {
            addMatchPoint(str);
        }
    }

    private void addMatchPoint(String str) {
        if (lottoNumber.contains(Integer.parseInt(str))) {
            this.matchPoint++;
        }
    }

    public int getMatchPoint() {
        return this.matchPoint;
    }
    public List<Integer> getLottoNumber() {
        return this.lottoNumber;
    }

    @Override
    public String toString() {
        return lottoNumber.toString();
    }
}
