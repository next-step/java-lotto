package edu.nextstep.lotto.view;

import java.util.List;

public class ResultView {

	private ResultView() {
	}

	public static void printHowManyPurchase(int number) {
		System.out.println(number + "개를 구매했습니다.");
	}

	public static void printLottos(List<List<Integer>> lottos) {
		lottos.forEach(System.out::println);
		System.out.println();
	}
}