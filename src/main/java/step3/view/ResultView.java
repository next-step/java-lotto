package step3.view;

import step3.domain.Lottos;
import step3.domain.number.LottoMatchingCount;
import step3.domain.result.LottoMatchingResult;
import step3.domain.result.Rank;
import step3.util.StringUtil;

public class ResultView {
  private static final String MATCHING_THREE = "3개 일치 (5,000원) - ";
  private static final String MATCHING_FOUR = "4개 일치 (50,000원) - ";
  private static final String MATCHING_FIVE = "5개 일치 (1,500,000원) - ";
  private static final String MATCHING_FIVE_WITH_BONUS = "5개 일치, 보너스 볼 일치(30,000,000원) - ";
  private static final String MATCHING_SIX = "6개 일치 (2,000,000,000원) - ";
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

  // TODO 수정
  public static void showSpecificResult(LottoMatchingResult lottoResult) {

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
