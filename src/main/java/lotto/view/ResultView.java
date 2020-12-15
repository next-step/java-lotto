package lotto.view;

public class ResultView {
	public ResultView() {
	}

	public void printMatchUI(int matchCount, int prizeMoney, int threeMatchCount) {
		System.out.println(String.format("%d개 일치 (%d원)- %d",matchCount, prizeMoney, threeMatchCount));
	}

	public void printEarningRateUI(double earningRate) {
		if (earningRate < 1){
			System.out.println(String.format("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", earningRate));
		}
		if(earningRate == 1){
			System.out.println(String.format("총 수익률은 %.2f입니다.(본전)", earningRate));
		}
		if(earningRate > 1){
			System.out.println(String.format("총 수익률은 %.2f입니다.(수익이 생겼습니다)", earningRate));
		}


	}
}
