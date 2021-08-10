package lotto.model;

<<<<<<< HEAD
import java.util.List;

public class Lotto {
    private static final int NUMBER_OF_LOTTO_NUMBERS = 6;
    private List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int countWinningNumbers(Lotto winningNumbers) {
        int count = 0;
        for (int i = 0; i < NUMBER_OF_LOTTO_NUMBERS; i++) {
            if (lottoNumbers.contains(winningNumbers.getNumbers().get(i))) {
=======
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

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
>>>>>>> origin/step2
                count++;
            }
        }
        return count;
    }

<<<<<<< HEAD
    public boolean contains(int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return lottoNumbers;
=======
    public boolean contains(LottoNumber number) {
        for (LottoNumber lottoNumber : lottoNumbers) {
            if (lottoNumber.equals(number)) {
                return true;
            }
        }
        return false;
    }

    public List<LottoNumber> getNumbers() {
        return new ArrayList<>(lottoNumbers);
>>>>>>> origin/step2
    }
}
