package com.kakao.lotto.supportInfo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinLottoInfo {
    private final List<Integer> winLottoNumbers;

    private static final String DELIMITER = ",";

    public WinLottoInfo(String winLotto) {
        this.winLottoNumbers = Arrays.stream(winLotto.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> getWinLottoNumbers() {
        return winLottoNumbers;
    }
}
