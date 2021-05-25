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

    public void print() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public void print(String resultInfo) {
        System.out.println(resultInfo);
    }
}
