package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    private static final int UNIT_PRICE = 1000;
    private int lottoAmount;
    private String result;


    public int getLottoAmount() {
        return lottoAmount;
    }

    public String getResult() {
        return result;
    }

    public int amonut(int price) {
        if (price % UNIT_PRICE != 0) {
            throw new IllegalArgumentException("로또의 1장당 가격은 1,000원입니다. 원하는 장수 만큼의 금액을 입력해주세요.");
        }
        return price / UNIT_PRICE;
    }

    public void lottoAmointPrint(int lottoAmount) {
        this.lottoAmount = amonut(lottoAmount);
        this.result = this.lottoAmount + "개를 구매했습니다.";
    }

    public void lottoPrint(Lotto lotto) {
        this.result = lotto.getNumbers().toString();
    }

    public void winningPrint(List<Integer> counts, double profit) {
        System.out.println("당첨통계");
        System.out.println("---------");
        for (int i = 0; i < counts.size(); i++) {
            System.out.printf("%d개 일치 (%d원)- %d개\n",
                    i+3,
                    Prize.getPrizeByRanking(counts.size() - i),
                    counts.get(i)
                    );
        }
        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)", profit);
    }
}
