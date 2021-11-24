package common.view;

import common.model.Number;
import lotto.application.Constant;
import lotto.model.*;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private OutputView() {
    }

    public static void print() {
        System.out.println();
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static void print(String... messages) {
        StringBuilder builder = new StringBuilder();
        for (String message : messages) {
            builder.append(message);
        }
        print(builder.toString());
    }

    public static void print(int message) {
        System.out.println(message);
    }

    public static void print(Number number) {
        print(number.getNumber());
    }

    public static void print(List<LottoNumber> lottoNumbers) {

        List<String> lottoNumbersString = lottoNumbers
                .stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        print("[", String.join(", ", lottoNumbersString), "]");

    }

    public static void print(Lotto lotto) {
        OutputView.print(String.valueOf(lotto.getLotto().size()), Constant.OUTPUT_MESSAGE_PURCHASE_LOTTO);
        for (LottoNumbers lottoNumbers : lotto.getLotto()) {
            print(lottoNumbers.getLottoNumbers());
        }
    }

    public static void print(LottoReport report, int purchaseAmount) {
        print("당첨 통계");
        print("-------------");
        for (LottoRank rank : LottoRank.valuesWithoutMiss()) {
            Number count = report.getLottoRankNumbers().getOrDefault(rank, new Number());
            print(rank, count);
        }

        float rateOfRevenue = report.calculateRateOfRevenue(purchaseAmount);
        print("총 수익률은 ", String.valueOf(rateOfRevenue), "입니다.");

    }

    public static void print(LottoRank rank, Number count) {
        StringBuilder output = new StringBuilder();
        output.append(rank.getMatchCount()).append("개 일치");
        if (LottoRank.SECOND.equals(rank)) {
            output.append(", 보너스 볼 일치");
        }
        output.append("(").append(rank.getAmount()).append("원) - ")
                .append(count.getNumber()).append("개");

        print(output.toString());
    }


}
