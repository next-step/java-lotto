package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private List<Number> lottoNumbers;

    private static final int SIZE = 6;

    public Lotto() {
    }

    private Lotto(List<Number> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto createLotto(List<Number> list) {
        if (list.size() > SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개 까지 입니다.");
        }
        return new Lotto(list);
    }

    public int equalsCount(List<Number> list) {
        return (int) lottoNumbers.stream()
                .filter(list::contains)
                .count();
    }

    public void sortLotto() {
        Collections.sort(lottoNumbers);
    }

    public List<Number> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public int getSize() {
        return lottoNumbers.size();
    }

    public static int getMaxSize() {
        return SIZE;
    }
}
