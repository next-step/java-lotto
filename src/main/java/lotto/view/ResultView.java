package lotto.view;

import lotto.model.LottoNumbers;

import java.util.List;

public class ResultView {

    public void print(List<LottoNumbers> lottoNumbers) {

        lottoNumbers.stream()
                    .map(LottoNumbers::printInfo)
                    .forEach(System.out::println);

        System.out.println();
    }
}
