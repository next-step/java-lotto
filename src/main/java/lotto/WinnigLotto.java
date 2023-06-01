package lotto;

import java.util.Collections;
import java.util.List;

public class WinnigLotto {

    private List<Number> lottoNumbers;
    private Number lottoBonusNumber;

    private static final int SIZE = 6;

    private WinnigLotto(List<Number> lottoNumbers, Number lottoBonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.lottoBonusNumber  = lottoBonusNumber;
    }

    public static WinnigLotto createLotto(List<Number> list, Number lottoBonusNumber) {
        if (list.size() > SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개 까지 입니다.");
        }
        return new WinnigLotto(list, lottoBonusNumber);
    }

    public List<Number> getWinningLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public Number getLottoBonusNumber() {
        return lottoBonusNumber;
    }
}
