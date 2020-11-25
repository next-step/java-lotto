package step2.view;

import step2.domain.dto.LottoDTO;

import java.util.List;

public class ResultView {

    public void showBoughtLotto(List<LottoDTO> lottoDTOS) {
        System.out.println(lottoDTOS.size() + "개를 구매했습니다.");
        for (LottoDTO lottoDTO : lottoDTOS) {
            System.out.println(lottoDTO.getNumbers());
        }

        System.out.println();
    }

    public void showLottoResult(List<Long> lottoResult) {

        long fourCount = lottoResult.stream().filter(money -> money.equals(5000L)).count();
        System.out.println("3개 일치 (5000원)- " + fourCount+"개");

        long threeCount = lottoResult.stream().filter(money -> money.equals(50000L)).count();
        System.out.println("4개 일치 (50000원)- " + threeCount+"개");

        long twoCount = lottoResult.stream().filter(money -> money.equals(1500000L)).count();
        System.out.println("5개 일치 (1500000)- " + twoCount+"개");

        long oneCount = lottoResult.stream().filter(money -> money.equals(2000000000L)).count();
        System.out.println("6개 일치 (2000000000)- " + oneCount+"개");

    }

    public void showBenefitPercent(double benefitPercent) {
        System.out.println("총 수익률은 " + String.format("%.2f", benefitPercent) + "입니다.");
    }
}
