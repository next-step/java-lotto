package lotto.view;

import lotto.domain.LottoNumbers;

import java.util.List;

public class ResultView {
    public void print(int manualBuyCount, int autoBuyCount){
        System.out.println("수동으로 " + manualBuyCount + "장 자동으로 " + autoBuyCount + "개를 구매했습니다.");
    }

    public void print(List<LottoNumbers> lottoNumbers) {

        lottoNumbers.stream()
                    .map(LottoNumbers::printInfo)
                    .forEach(System.out::println);

        System.out.println();
    }

    public void print(String resultInfo) {
        System.out.println(resultInfo);
    }

    public void print() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
    }
}
