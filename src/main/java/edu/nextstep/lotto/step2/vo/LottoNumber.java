package edu.nextstep.lotto.step2.vo;

import edu.nextstep.lotto.step2.domain.WinningList;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {

    private static final int LOTTO_MAX_NUMBER = 45;
    private final List<Integer> lottoNumbers;

    public LottoNumber() {
        List<Integer> fullLottoNumbers = IntStream.range(1, LOTTO_MAX_NUMBER).boxed().collect(Collectors.toList());
        Collections.shuffle(fullLottoNumbers);

        lottoNumbers = fullLottoNumbers.subList(0, 6);
        Collections.sort(lottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public int getResult(WinningList winningList) {
        return winningList.getWinningNumberList().stream()
                .mapToInt(winningNumber -> lottoNumbers.contains(winningNumber.getNumber()) ? 1 : 0)
                .sum();
    }
}
