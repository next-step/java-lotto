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

    public static Lotto create(List<Integer> lottoNumbers) {
        if (isNotLottoCount(lottoNumbers)) {
            throw new IllegalArgumentException("6자리의 숫자를 입력해 주세요.");
        }
        if (isSameNumber(lottoNumbers)) {
            throw new IllegalArgumentException("같은 숫자가 포함돼 있습니다.");
        }

        return new Lotto(lottoNumbers);
    }

    private static boolean isSameNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.stream().distinct().count() != LottoConstant.NEED_COUNT;
    }

    private Lotto(List<Integer> lottoNumbers) {
        for (Integer lottoNumber : lottoNumbers) {
            this.numbers.add(LottoNo.create(lottoNumber));
        }
        this.isAuto = false;
    }

    private static boolean isNotLottoCount(List<Integer> lottoNumbers) {
        return lottoNumbers.size() != LottoConstant.NEED_COUNT;
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

    public boolean isContainsBonusNumber(LottoNo bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }

    public boolean isAuto() {
        return this.isAuto;
    }
}
