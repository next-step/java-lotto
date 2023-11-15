package study.step2.view;

import java.util.List;

import study.step2.domain.LottoNumbers;

public class ResultView {

    public static void lottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void show(List<LottoNumbers> results) {
        results.forEach(lottoNumbers -> System.out.println(lottoNumbers.lottoNumbers().toString()));
        System.out.println();
    }

    public static void statistics() {

    }
}
