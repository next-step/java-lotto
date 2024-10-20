package lotto.lotto;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto implements LottoGenerator {

    private static final int LOTTO_CNT = 6;
    private static final int MAX_LOTTO_NUMBER = 45;

    public final List<LottoNumber> lottoNumbers;

    public Lotto() {
        this.lottoNumbers = new ArrayList<>();
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto generateLotto() {
        List<LottoNumber> newLottoNumbers = new ArrayList<>();
        addLottos(newLottoNumbers);
        shuffleLotto(newLottoNumbers);
        answerLotto(newLottoNumbers);
        sortLotto(newLottoNumbers);
        return new Lotto(newLottoNumbers);
    }

    public void addLottos(List<LottoNumber> lottoNumbers) {
        for (int i = 1; i <= MAX_LOTTO_NUMBER; i++) {
            lottoNumbers.add(LottoNumber.from(i));
        }
    }

    private void shuffleLotto(List<LottoNumber> lottoNumbers) {
        Collections.shuffle(lottoNumbers);
    }

    private void sortLotto(List<LottoNumber> lottoNumbers) {
        Collections.sort(lottoNumbers);
    }

    public void answerLotto(List<LottoNumber> lottoNumbers) {
        for (int i = 0; i < MAX_LOTTO_NUMBER - LOTTO_CNT; i++) {
            lottoNumbers.remove(0);
        }
    }

    public List<LottoNumber> getLotto() {
        return lottoNumbers;
    }

    public int findLottoNumber(int idx) {
        return lottoNumbers.get(idx).getNumber();
    }

    public int calculateMatchingCnt(LottoWinning lottoWinning) {
        Set<Integer> lottoWinSet = lottoWinning.getWinningLotto();
        Set<Integer> lottoNumberSet = getLottonumberSet();
        lottoNumberSet.retainAll(lottoWinSet);
        return lottoNumberSet.size();
    }

    public Set<Integer> getLottonumberSet() {
        return lottoNumbers.stream().map(LottoNumber::getNumber).collect(Collectors.toSet());
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < lottoNumbers.size(); i++) {
            str += findLottoNumber(i) + ",";
        }
        return str.substring(0, str.length() - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoNumbers);
    }
}
