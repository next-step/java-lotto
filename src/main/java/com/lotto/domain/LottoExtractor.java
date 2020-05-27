package com.lotto.domain;

import java.util.List;

public interface LottoExtractor {
    List<Integer> extractLottoNumbers(List<Integer> availableLottoNumbers);
}
