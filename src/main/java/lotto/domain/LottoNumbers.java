package lotto.domain;

import lotto.common.MessageCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbers {
    private List<LottoNo> lottoNumbers;

    public static LottoNumbers generateManualOf(int[] numbers) {
        return new LottoNumbers(numbers);
    }

    public static LottoNumbers generateAutoOf(LottoNumberGeneratorStrategy lottoNumberGeneratorStrategy) {
        return new LottoNumbers(new LottoNumberGenerator());
    }

    public static LottoNumbers generateWinningLottoOf(String[] numbers) {
        return new LottoNumbers(numbers);
    }

    private LottoNumbers(int[] numbers) {
        lottoNumbers = new ArrayList<LottoNo>();
        for (int number : numbers)
            lottoNumbers.add(new LottoNo(number));
        validateLottoNumbers();
    }

    private LottoNumbers(String[] numbers) {
        lottoNumbers = new ArrayList<LottoNo>();
        for (String number : numbers)
            lottoNumbers.add(new LottoNo(Integer.parseInt(number)));
        validateLottoNumbers();
    }

    private void validateLottoNumbers() {
        if (lottoNumbers.size() > 6)
            throw new IllegalArgumentException(MessageCode.INVALID_OVER_LOTTO_NUMBERS.message());

        if (lottoNumbers.size() < 6)
            throw new IllegalArgumentException(MessageCode.INVALID_INPUT_LOTTO_NUMBER_COUNT.message());

        Set<LottoNo> transSet = new HashSet<>(lottoNumbers);
        if (transSet.size() < 6)
            throw new IllegalArgumentException(MessageCode.INVALID_DUP_LOTTO_NUMBERS.message());
    }

    private LottoNumbers(LottoNumberGeneratorStrategy lottoNumberGeneratorStrategy) {
        lottoNumbers = new ArrayList<LottoNo>();
        lottoNumbers = lottoNumberGeneratorStrategy.generateLottoNumber();
    }

    public List<LottoNo> lottoNumbers() {
        return lottoNumbers;
    }

    public boolean contains(int number) {
        for (LottoNo lottoNo : lottoNumbers) {
            if (lottoNo.lottNo() == number)
                return true;
        }
        return false;
    }

    public List<Integer> showLottoNoList() {
        List<Integer> lottoNoArray = new ArrayList<Integer>();
        for (LottoNo lottoNo : lottoNumbers)
            lottoNoArray.add(lottoNo.lottNo());

        return lottoNoArray;
    }
}
