package step2.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> lotto;

    private static final int LOTTO_NUMBER_COUNT = 6;

    public Lotto(List<LottoNumber> lotto) {
        this.lotto = lotto;
    }

    public Lotto(String lotto) {
        isBlank(lotto);
        isValidNumberCount(lotto);

        this.lotto = new ArrayList<>();
        setLottoNumber(lotto);
    }

    private void setLottoNumber(String lotto) {
        for (String number : lotto.split(",")) {
            LottoNumber lottoNumber = new LottoNumber(number);
            isDuplicate(lottoNumber);
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
            throw new IllegalArgumentException("로또 번호는 6개 입력해주셔야합니다.");
        }
    }

    public void isDuplicate(LottoNumber lottoNumber) {
        if (lotto.contains(lottoNumber)) {
            throw new IllegalArgumentException("번호가 중복되었습니다. 다시 입력해주세요");
        }
    }


    public int size() {
        return lotto.size();
    }

    public List<Integer> getLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();

        for (LottoNumber lottoNumber : lotto) {
            numbers.add(lottoNumber.getLottoNumber());
        }
        return numbers;
    }

}
