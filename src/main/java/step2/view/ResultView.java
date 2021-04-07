package step2.view;

import step2.domain.Lottos;
import step2.domain.number.LottoMatchingNumber;
import step2.domain.result.LottoMatchingResult;
import step2.util.StringUtil;

public class ResultView {
  private static final String MATCHING_THREE = "3개 일치 (5000원)- ";
  private static final String MATCHING_FOUR = "4개 일치 (50000원)- ";
  private static final String MATCHING_FIVE = "5개 일치 (1500000원)- ";
  private static final String MATCHING_SIX = "6개 일치 (2000000000원)- ";
  private static final String YIELD_PREFIX = "총 수익률은 ";
  private static final String YIELD_POSTFIX = "입니다.";
  private static final String QUANTITY_MESSAGE = "개를 구매했습니다.";
  private static final String DIGIT = "개";

  private ResultView() {
  }

  public static void firstNotice(Lottos lottos) {
    CommonView.println(lottos.quantity().showCount() + QUANTITY_MESSAGE);
    CommonView.println(lottos.toString());
  }

  public static void showSpecificResult(LottoMatchingResult lottoResult) {
    CommonView.println(MATCHING_THREE + lottoResult.toStringSpecificResult(new LottoMatchingNumber(3)) + DIGIT);
    CommonView.println(MATCHING_FOUR + lottoResult.toStringSpecificResult(new LottoMatchingNumber(4)) + DIGIT);
    CommonView.println(MATCHING_FIVE + lottoResult.toStringSpecificResult(new LottoMatchingNumber(5)) + DIGIT);
    CommonView.println(MATCHING_SIX + lottoResult.toStringSpecificResult(new LottoMatchingNumber(6)) + DIGIT);
  }

  public static void showYield(Double yield) {
    CommonView.println(YIELD_PREFIX + StringUtil.doubleToStringWithRounding(yield) + YIELD_POSTFIX);
  }
}
