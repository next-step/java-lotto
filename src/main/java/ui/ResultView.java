package ui;

import lotto.LottoReport;

public class ResultView {

	public static final String STATISTICS = "당첨 통계";
	public static final String LINE = "---------";
	public static final String count = "개";
	public static final String INTRO_OF_THREE_MATCHED = "3개 일치 (5000원)- ";
	public static final String INTRO_OF_FOUR_MATCHED = "4개 일치 (50000원)- ";
	public static final String INTRO_OF_FIX_MATCHED = "5개 일치 (1500000원)- ";
	public static final String INTRO_OF_SIX_MATCHED = "6개 일치 (2000000000원)- ";
	public static final String TOTAL = "총 수익률은 ";
	public static final String END = "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

	public void drawResult(LottoReport lottoResultReport) {
		System.out.println(STATISTICS);
		System.out.println(LINE);
		System.out.println(INTRO_OF_THREE_MATCHED +lottoResultReport.fourthPlace()+ count);
		System.out.println(INTRO_OF_FOUR_MATCHED +lottoResultReport.thirdPlace()+count);
		System.out.println(INTRO_OF_FIX_MATCHED +lottoResultReport.secondPlace()+count);
		System.out.println(INTRO_OF_SIX_MATCHED +lottoResultReport.firstPlace()+count);
		System.out.println(TOTAL + Math.floor(lottoResultReport.profit() * 100) / 100.0 + END);
	}
}
