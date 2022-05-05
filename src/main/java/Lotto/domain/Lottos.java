package Lotto.domain;

import java.util.*;

public class Lottos {

    private List<Lotto> list = new ArrayList<>();

    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;

    public Lottos() {
    }

    public void createLottoNumbers(int lottoCount) {
        List<Integer> tmpNumbers = createAllNumbers();

        for (int i = 0; i < lottoCount; ++i) {
            pickLottoNumbers(tmpNumbers);
        }
    }

    private List<Integer> createAllNumbers() {
        List<Integer> tmpNumbers = new ArrayList<>();

        for (int i = 0; i < LOTTO_MAX_NUMBER; ++i) {
            tmpNumbers.add(i+1);
        }

        return tmpNumbers;
    }

    private void pickLottoNumbers(List<Integer> tmpNumbers) {
        List<Integer> lottoNumbers = new ArrayList<>();

        Collections.shuffle(tmpNumbers);
        for (int j = 0; j < LOTTO_NUMBER_SIZE; ++j) {
            lottoNumbers.add(tmpNumbers.get(j));
        }

        Collections.sort(lottoNumbers);

        list.add(new Lotto(lottoNumbers));
    }

    public Lotto getLotto(int idx) {
        return list.get(idx);
    }

    public int getLottoCnt() {
        return list.size();
    }

    public List<Lotto> getLottoList() {
        return list;
    }
}
