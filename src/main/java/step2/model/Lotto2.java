package step2.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto2 {
    private final List<LottoNumber> lotto;

    private static final int LOTTO_NUMBER_COUNT = 6;

    public Lotto2(String lotto) {
        isBlank(lotto);
        isValidNumberCount(lotto);

        this.lotto = new ArrayList<>();
        setLotto(lotto);
    }

    private void setLotto(String lotto) {
        for (String number : lotto.split(",")) {
            LottoNumber lottoNumber = new LottoNumber(number);
            isDuplicate(this.lotto, lottoNumber);
            this.lotto.add(lottoNumber);
        }
    }

    public List<LottoNumber> getlotto() {
        return lotto;
    }

    private void isBlank(String lotto) {
        if (lotto == null || lotto.isEmpty()) {
            throw new IllegalArgumentException("빈값입니다.다시 입력해주세요.");
        }
    }

    private void isValidNumberCount(String lotto) {
        String[] lottoNumbers = lotto.split(",");
        if (lottoNumbers.length < LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("당첨 번호는 6개 입력해주셔야합니다.");
        }
    }

    private void isDuplicate(List<LottoNumber> lotto, LottoNumber lottoNumber) {
        if (lotto.contains(lottoNumber)) {
            throw new IllegalArgumentException("당첨번호가 중복되었습니다. 다시 입력해주세요");
        }
    }


    public int size() {
        return lotto.size();
    }
}
