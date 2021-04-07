package step4.view;

import step4.domain.Lottos;
import step4.domain.result.LottoMatchingResult;
import step4.domain.result.Rank;

public class ResultView {
  private static final String MATCHING_THREE = "3개 일치 (5,000원) - ";
  private static final String MATCHING_FOUR = "4개 일치 (50,000원) - ";
  private static final String MATCHING_FIVE = "5개 일치 (1,500,000원) - ";
  private static final String MATCHING_FIVE_WITH_BONUS = "5개 일치, 보너스 볼 일치(30,000,000원) - ";
  private static final String MATCHING_SIX = "6개 일치 (2,000,000,000원) - ";
  private static final String YIELD_PREFIX = "총 수익률은 ";
  private static final String YIELD_POSTFIX = "입니다.";
  private static final String QUANTITY_PREFIX = "수동으로 ";
  private static final String QUANTITY_MIDDLE = ", 자동으로 ";
  private static final String QUANTITY_MESSAGE = "개를 구매했습니다.";
  private static final String RESULT_HEADER = "당첨 통계";
  private static final String RESULT_LINE_SPLITTING_TEXT = "---------";
  private static final String DIGIT = "개";

  private ResultView() {
  }

  public static void firstNotice(Lottos manualBoughtLottos, Lottos randomBoughtLottos) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder
      .append(QUANTITY_PREFIX)
      .append(manualBoughtLottos.quantity().showCount())
      .append(QUANTITY_MIDDLE)
      .append(randomBoughtLottos.quantity().showCount())
      .append(QUANTITY_MESSAGE)
    ;
    CommonView.println(stringBuilder.toString());

    stringBuilder = new StringBuilder()
      .append(manualBoughtLottos.toString())
      .append(randomBoughtLottos.toString());
    CommonView.println(stringBuilder.toString());
  }

  public static void showSpecificResult(LottoMatchingResult lottoResult) {
    CommonView.println(RESULT_HEADER);
    CommonView.println(RESULT_LINE_SPLITTING_TEXT);
    CommonView.println(MATCHING_THREE + lottoResult.toStringSpecificResult(Rank.FIFTH) + DIGIT);
    CommonView.println(MATCHING_FOUR + lottoResult.toStringSpecificResult(Rank.FOURTH) + DIGIT);
    CommonView.println(MATCHING_FIVE + lottoResult.toStringSpecificResult(Rank.THIRD) + DIGIT);
    CommonView.println(MATCHING_FIVE_WITH_BONUS + lottoResult.toStringSpecificResult(Rank.SECOND) + DIGIT);
    CommonView.println(MATCHING_SIX + lottoResult.toStringSpecificResult(Rank.FIRST) + DIGIT);
  }

  public static void showYield(String yield) {
    CommonView.println(YIELD_PREFIX + yield + YIELD_POSTFIX);
  }
}
