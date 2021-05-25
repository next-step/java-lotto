package lotto;

public class ResultView {

	public static void printBuyResult(Lottos lottos) {
		System.out.println(lottos.count() + "개를 구매했습니다.");
		lottos.values().forEach(System.out::println);
		System.out.println();
	}

	public static void printWinningResult(Lottos lottos) { // TODO WinningResult parameter 추가
		System.out.println("당첨 통계");
		System.out.println("---------");
		// TODO 결과 집계, 결과 출력, 수익률 계산
	}
}
