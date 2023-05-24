package lotto;

import java.util.Collections;
import java.util.List;

public class WinnigLotto {

    private List<Number> lottoNumbers;

    private static final int SIZE = 7;
    private static final int BASIC_NUMBER_SIZE = 6;

    private WinnigLotto(List<Number> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static WinnigLotto createLotto(List<Number> list) {
        if (list.size() > SIZE) {
            throw new IllegalArgumentException("로또 번호는 7개 까지 입니다.");
        }
        return new WinnigLotto(list);
    }

    public List<Number> getWinnigLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public Number getLottoBonusNumber() {
        return lottoNumbers.get(SIZE-1);
    }
}
