package lotto.view;

import lotto.LottoResult;

import static lotto.Prize.*;

import lotto.Money;
import lotto.Prize;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ResultView {
    public static final int UNIT_PRICE = 1000;

    private final LottoResult lottoResult;

    public ResultView(LottoResult lottoResult) {
        this.lottoResult = lottoResult;
    }

    public void showResult() {
        System.out.println("당첨 통계\n---------");
        for (Prize prize : Arrays.stream(values()).filter(elem -> elem != NONE).collect(Collectors.toList())) {
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append(prize.getMatchCount())
                    .append("개 일치");

            forSecond(prize, stringBuilder);

            stringBuilder.append("(")
                    .append(new BigDecimal(prize.getPrize()))
                    .append("원)- ")
                    .append(lottoResult.countByPrize(prize))
                    .append("개");

            System.out.println(stringBuilder);
        }

        System.out.println("총 수익률은 " + String.format("%.2f", this.lottoResult.rate(new Money(UNIT_PRICE))) + "입니다.");
    }

    private void forSecond(Prize prize, StringBuilder stringBuilder) {
        if (prize == SECOND) {
            stringBuilder.append(", 보너스 볼 일치");
        }
    }
}
