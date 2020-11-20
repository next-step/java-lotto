package step2.lotto.automatic.view;

import step2.lotto.automatic.domain.LottoStatus;

import java.util.List;

public class OuterStep2View {

    public void printBuyLotto(int buyLottoCount) {
        System.out.println(buyLottoCount + "개를 구매했습니다.");
    }

    public void printAutoLottoNumbers(List<List<Integer>> paramList) {
        printDetailAutoNumbers(paramList.get(0));
        System.out.print(System.lineSeparator());

        for (int i = 1; i < paramList.size(); i++) {
            printDetailAutoNumbers(paramList.get(i));
            System.out.print(System.lineSeparator());
        }
    }

    private void printDetailAutoNumbers(List<Integer> paramList) {
        System.out.print("[");
        System.out.print(paramList.get(0));
        for (int i = 1; i < paramList.size(); i++) {
            System.out.print(", " + paramList.get(i));
        }

        System.out.print("]");
    }

    public void printLottoResult(LottoStatus lottoStatus) {
        System.out.println(
                        lottoStatus.getSameCount() + "개 일치 " + "(" + lottoStatus.getPlusPrice()
                        + ")- " + lottoStatus.getWinningCount() + " 개");
    }

    public void printeEarningRate(double earningRate, String printType){
        System.out.println("총 수익률은 " +  earningRate + printType);
    }
}
