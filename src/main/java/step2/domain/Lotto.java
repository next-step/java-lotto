package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lotto {

    private final List<LottoNo> numbers = new ArrayList<>();
    private final boolean isAuto;

    public Lotto() {
        this.isAuto = true;
        createLottoNumber();
    }

    public Lotto(List<Integer> lottoNumbers) {
        for (Integer lottoNumber : lottoNumbers) {
            this.numbers.add(LottoNo.create(lottoNumber));
        }
        this.isAuto = false;
    }

    private void createLottoNumber() {
        List<LottoNo> allLottoNumber = LottoNumberGenerator.LOTTO_GENERATOR;
        Collections.shuffle(allLottoNumber);
        List<LottoNo> lottoNos = allLottoNumber.subList(LottoConstant.ZERO, LottoConstant.NEED_COUNT);
        lottoNos.sort(Comparator.comparingInt(LottoNo::getNumber));
        this.numbers.addAll(lottoNos);
    }

    public List<LottoNo> getNumbers() {
        return this.numbers;
    }

    public boolean isContains(LottoNo winNumber) {
        return this.numbers.contains(winNumber);
    }

    public boolean isContainsBonusNumber(int bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }

    public boolean isAuto() {
        return this.isAuto;
    }
}
