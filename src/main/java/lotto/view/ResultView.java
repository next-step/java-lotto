package lotto.view;

import lotto.domain.LottoNumber;

import java.util.List;

public class ResultView {

    public static void printLottoNumbers(int lottoCount, List<LottoNumber> lottoNumbers) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

//  당첨 통계
//---------
//  3개 일치 (5000원)- 1개
//  4개 일치 (50000원)- 0개
//  5개 일치 (1500000원)- 0개
//  6개 일치 (2000000000원)- 0개
//   총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
}
