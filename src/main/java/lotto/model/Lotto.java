package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int LOTTO_SIZE = 6;

    private List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        checkLottoSize(lottoNumbers);
        checkLottoNumbers(lottoNumbers);
        this.lottoNumbers = new ArrayList<>(sort(lottoNumbers));
    }

    private void checkLottoSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 숫자 갯수는 6개여야 합니다.");
        }
    }

    private void checkLottoNumbers(List<LottoNumber> lottoNumbers) {
        boolean accordance = false;
        for (int i = 0; i < LOTTO_SIZE; i++) {
            for (int j = 0; j < i; j++) {
                if (lottoNumbers.get(i) == lottoNumbers.get(j)) {
                    accordance = true;
                    break;
                }
            }
        }
        if (accordance) {
            throw new IllegalArgumentException("로또 번호는 모두 달라야 합니다.");
        }
    }

    private List<LottoNumber> sort(List<LottoNumber> lottoNumbers) {
        List<Integer> lottoValues = new ArrayList<>();
        for(LottoNumber lottoNumber : lottoNumbers) {
            lottoValues.add(Integer.parseInt(lottoNumber.toString()));
        }
        Collections.sort(lottoValues);
        List<LottoNumber> sortedlottoNumbers = new ArrayList<>();
        for(int lottoValue : lottoValues) {
            sortedlottoNumbers.add(LottoNumber.of(lottoValue));
        }
        return new ArrayList<>(sortedlottoNumbers);
    }

    public int countWinningNumbers(Lotto winningLotto) {
        int count = 0;
        for (LottoNumber lottoNumber : lottoNumbers) {
            if (winningLotto.contains(lottoNumber)) {
                count++;
            }
        }
        return count;
    }

    public boolean contains(LottoNumber number) {
        for (LottoNumber lottoNumber : lottoNumbers) {
            if (lottoNumber.isSame(number)) {
                return true;
            }
        }
        return false;
    }

    public List<LottoNumber> getNumbers() {
        return new ArrayList<>(lottoNumbers);
    }
}
