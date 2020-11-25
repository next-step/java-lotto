package step2.view;

import step2.LottoDTO;

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
        System.out.println(fourCount + "개 일치 (5000원)- " + fourCount+"개");

        long threeCount = lottoResult.stream().filter(money -> money.equals(50000)).count();
        System.out.println(threeCount + "개 일치 (5000원)- " + threeCount+"개");

        long twoCount = lottoResult.stream().filter(money -> money.equals(5000L)).count();
        System.out.println(twoCount + "개 일치 (1500000)- " + twoCount+"개");

        long oneCount = lottoResult.stream().filter(money -> money.equals(5000L)).count();
        System.out.println(oneCount + "개 일치 (2000000000)- " + oneCount+"개");

    }
}
