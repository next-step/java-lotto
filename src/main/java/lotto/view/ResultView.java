package lotto.view;

import lotto.domain.*;

import java.util.Objects;
import java.util.stream.Collectors;

public class ResultView {

  private static final String DELIMITER = ",";
  private static final String PRINT_LOTTO_COUNT = "%d개를 구매했습니다.\n";
  private static final String PRINT_LOTTO_STATICS = "당첨 통계\n";
  private static final String PRINT_DOTTED_LINE = "--------\n";
  private static final String PRINT_BENEFIT = "이득";
  private static final String PRINT_LOSS = "손해";
  private static final String PRINT_LOTTO_EARNING_RATE
      = "총 수익률은 %.2f입니다.(기준은 1이기 때문에 결과적으로 %s란 얘기)\n";


  public void printLottoCount(int lottoCount) {
    System.out.printf(PRINT_LOTTO_COUNT, lottoCount);
  }

  public void printLottoList(LottoList lottoList) {
    String printLottolist = "";
    for (Lotto lotto : lottoList.getLottoList()) {
      printLottolist += "[";
      printLottolist += printEachLotto(lotto);
      printLottolist += "]\n";
    }
    System.out.println(printLottolist.trim());
  }

  private String printEachLotto(Lotto lotto) {
    return lotto.getLottoNumberList()
        .getLottoNumbers()
        .stream()
        .map(LottoNumber::toString)
        .collect(Collectors.joining(DELIMITER));
  }

  public void printLottoStatics(LottoStatistics lottoStatistics) {
    StringBuilder sb = new StringBuilder();
    sb.append(PRINT_LOTTO_STATICS);
    sb.append(PRINT_DOTTED_LINE);

    lottoStatistics.getlottoStaticResultMap()
        .forEach((LottoRank rank, Integer count) -> {
          sb.append(rank.getMatchingCount() + "개 일치");
          if (rank.equals(LottoRank.SECOND)) {
            sb.append(", 보너스볼 일치" );
          }
          sb.append(" ("+ rank.getMatchingPrice() + "원)");
          sb.append(" - " + count + "개\n");
        });

    System.out.println(sb.toString().trim());
  }


  public void printLottoEarningRate(double earningRate, boolean isBenefit) {
    String benefitOrLoss = (isBenefit) ? PRINT_BENEFIT : PRINT_LOSS;
    System.out.printf(PRINT_LOTTO_EARNING_RATE, earningRate, benefitOrLoss);
  }

}
