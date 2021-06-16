package lotto.domain;

import lotto.common.Constant;
import lotto.common.MessageCode;
import lotto.exceptions.DuplicatedLottoNumbersException;
import lotto.exceptions.OverSixLottoCountException;
import lotto.exceptions.UnderSixLottoCountException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public class LottoNumbers {
    private List<LottoNo> lottoNumbers;

    public static LottoNumbers generateManualOf(int[] numbers) {
        return new LottoNumbers(numbers);
    }

    public static LottoNumbers generateAutoOf(LottoNumberGeneratorStrategy lottoNumberGeneratorStrategy) {
        return new LottoNumbers(LottoNumberGenerator.getInstance());
    }

    private LottoNumbers(int[] numbers) {
        lottoNumbers = new ArrayList<LottoNo>();
        for (int number : numbers)
            lottoNumbers.add(new LottoNo(number));
        validateLottoNumbers();
    }

    private void validateLottoNumbers() {
        if (lottoNumbers.size() > Constant.LOTTO_NUMBER_COUNT.value())
            throw new OverSixLottoCountException();

        if (lottoNumbers.size() < Constant.LOTTO_NUMBER_COUNT.value())
            throw new UnderSixLottoCountException();

        Set<LottoNo> transSet = new HashSet<>(lottoNumbers);
        if (transSet.size() < Constant.LOTTO_NUMBER_COUNT.value())
            throw new DuplicatedLottoNumbersException();
    }

    private LottoNumbers(LottoNumberGeneratorStrategy lottoNumberGeneratorStrategy) {
        lottoNumbers = new ArrayList<LottoNo>();
        lottoNumbers = lottoNumberGeneratorStrategy.generateLottoNumber();
    }

    public List<LottoNo> lottoNumbers() {
        return lottoNumbers;
    }

    public boolean contains(LottoNo targetLottoNo) {
        boolean result = false;
        for (LottoNo lottoNo : lottoNumbers) {
            result = isSame(lottoNo, targetLottoNo, result);
        }
        return result;
    }

    private boolean isSame(LottoNo lottoNo, LottoNo targetLottoNo, boolean result) {
        if (result == true)
            return true;
        if (lottoNo.equals(targetLottoNo) && result == false)
            return true;
        return false;
    }

    public void foreach(Consumer<LottoNo> lottoNo) {
        lottoNumbers.forEach(lottoNo);
    }

    public List<Integer> showLottoNoList() {
        List<Integer> lottoNoArray = new ArrayList<Integer>();
        for (LottoNo lottoNo : lottoNumbers)
            lottoNoArray.add(lottoNo.lottNo());

        return lottoNoArray;
    }
}
