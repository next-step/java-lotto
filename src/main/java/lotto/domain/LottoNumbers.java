package lotto.domain;

import lotto.common.MessageCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbers {
    private List<LottoNo> lottoNumbers;

    public LottoNumbers(int[] numbers) {
        lottoNumbers = new ArrayList<LottoNo>();
        for (int number : numbers)
            lottoNumbers.add(new LottoNo(number));
        validateDuplicateLottoNumbers();
    }

    public LottoNumbers(String[] numbers) {
        lottoNumbers = new ArrayList<LottoNo>();
        for (String number : numbers)
            lottoNumbers.add(new LottoNo(Integer.parseInt(number)));
        validateDuplicateLottoNumbers();
    }

    private void validateDuplicateLottoNumbers() {
        Set<LottoNo> transSet = new HashSet<>(lottoNumbers);
        if (transSet.size() < 6)
            throw new IllegalArgumentException(MessageCode.INVALID_DUP_LOTTO_NUMBERS.message());

        if (transSet.size() > 6)
            throw new IllegalArgumentException(MessageCode.INVALID_OVER_LOTTO_NUMBERS.message());
    }

    public LottoNumbers(LottoNumberGeneratorStrategy lottoNumberGeneratorStrategy) {
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
