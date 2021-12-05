package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public void printBoughtResult(List<Lotto> lottoList) {
        StringBuilder result = new StringBuilder();
        result.append(lottoList.size())
                .append("개를 구매했습니다.");
        System.out.println(result);
        lottoList.forEach((Lotto lotto ) -> printLottoNumbers(lotto.getLottoNumbers()));
    }

    public void printLottoNumbers(LottoNumbers numbers) {
        System.out.println(parseLottoNumbers(numbers));
    }

    List<Integer> parseLottoNumbers(final LottoNumbers lottoNumbers) {
        return lottoNumbers.getLottoNumbers().stream()
                .map(LottoNumber::getLottoNumber)
                .collect(Collectors.toList());
    }
}
