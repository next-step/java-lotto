package com.lotto.domain;

import com.lotto.helper.LottoViewHelper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ManualLottoExtractor implements LottoExtractor {

    private static final String DUPLICATE_LOTTO_NUMBER_EXCEPTION_MESSAGE = "수동으로 입력한 로또 번호에 중복이 있습니다.";

    @Override
    public List<Integer> extractLottoNumbers(List<Integer> availableLottoNumbers) {
        checkDuplicateLottoNumber(availableLottoNumbers);
        return availableLottoNumbers;
    }

    private void checkDuplicateLottoNumber(List<Integer> lottoNumbers) {
        Set<Integer> duplicateContainer = new HashSet<>(lottoNumbers);
        if (duplicateContainer.size() != LottoViewHelper.COUNT_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER_EXCEPTION_MESSAGE);
        }
    }
}
