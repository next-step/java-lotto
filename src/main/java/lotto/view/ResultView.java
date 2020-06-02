package lotto.view;

import lotto.domain.Lotto;

public class ResultView {

    public static void printLottoNumbers(Lotto lotto) {
        System.out.println(lotto.getLottoCount() + "개를 구매했습니다.");

        lotto.getLottoNumbers().forEach(lottoNumber -> System.out.println(lottoNumber.getNumbers()));
    }

//  당첨 통계
//---------
//  3개 일치 (5000원)- 1개
//  4개 일치 (50000원)- 0개
//  5개 일치 (1500000원)- 0개
//  6개 일치 (2000000000원)- 0개
//   총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
}
