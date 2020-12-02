package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = new ArrayList<>();
        createLottoNumber();
    }

    public Lotto(List<Integer> lottoNumbers) {
        numbers = new ArrayList<>(lottoNumbers);
    }

    private void createLottoNumber() {
        List<Integer> allLottoNumber = LottoNumberGenerator.LOTTO_GENERATOR;
        Collections.shuffle(allLottoNumber);
        this.numbers.addAll(allLottoNumber.subList(LottoConstant.ZERO, LottoConstant.NEED_COUNT));
        Collections.sort(this.numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public boolean isContains(Integer winNumber) {
        return this.numbers.contains(winNumber);
    }

    public boolean isContainsBonusNumber(int bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }
}
