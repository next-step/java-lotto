package common.view;

import common.model.Number;
import lotto.application.Constant;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.LottoRank;
import lotto.model.LottoReport;

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
        OutputView.print(String.format(Constant.OUTPUT_MESSAGE_PURCHASE_LOTTO_FORMAT, lotto.getLottoSize()));
        print(lotto.toString());
    }

    public static void print(Lotto lotto, int manualLottoCount) {
        int autoLottoCount = lotto.getLottoSize() - manualLottoCount;
        OutputView.print(String.format(Constant.OUTPUT_MESSAGE_PURCHASE_MIX_LOTTO_FORMAT, manualLottoCount, autoLottoCount));
        print(lotto.toString());
    }

    public static void print(LottoReport report, int purchaseAmount) {
        print("당첨 통계");
        print("-------------");
        print(report.toString());
        print(String.format(Constant.OUTPUT_MESSAGE_CALCULATE_RATE_OF_REVENUE_FORMAT, report.calculateRateOfRevenue(purchaseAmount)));
    }

    public static void print(LottoRank rank, Number count) {
        String format = Constant.OUTPUT_MESSAGE_REPORT_FORMAT;
        if (rank.equals(LottoRank.SECOND)) {
            rank.toString();
            format = Constant.OUTPUT_MESSAGE_REPORT_SECOND_FORMAT;
        }

        print(String.format(format, rank.getMatchCount(), rank.getAmount(), count));

    }


}
