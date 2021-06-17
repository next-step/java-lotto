package lotto.domain;

import lotto.common.Constant;
import lotto.exceptions.DuplicatedLottoNumbersException;
import lotto.exceptions.OverSixLottoCountException;
import lotto.exceptions.UnderSixLottoCountException;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class LottoNumbers {
    private List<LottoNo> lottoNumbers;

    public static LottoNumbers generateManualOf(int[] numbers) {
        return new LottoNumbers(numbers);
    }

    public static LottoNumbers generateAutoOf(LottoNumberGeneratorStrategy lottoNumberGeneratorStrategy) {
        return new LottoNumbers(new LottoNumberGenerator());
    }

    private LottoNumbers(int[] numbers) {
        validateLottoNumbers(numbers);
        lottoNumbers = new ArrayList<LottoNo>();
        for (int number : numbers)
            lottoNumbers.add(new LottoNo(number));
    }

    public void validateLottoNumbers(int [] numbers) {

        if (numbers.length > Constant.LOTTO_NUMBER_COUNT.value())
            throw new OverSixLottoCountException();

        if (numbers.length < Constant.LOTTO_NUMBER_COUNT.value())
            throw new UnderSixLottoCountException();

        List numbersList = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        Set<Integer> transSet = new HashSet<>(numbersList);
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

    public List<Integer> showLottoNoList() {
        List<Integer> lottoNoArray = new ArrayList<Integer>();
        for (LottoNo lottoNo : lottoNumbers)
            lottoNoArray.add(lottoNo.lottNo());

        return lottoNoArray;
    }

    public Iterator<LottoNo> iterator() {
        return lottoNumbers.iterator();
    }
}
