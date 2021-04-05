package lotto.view;

import lotto.model.Lotto;

public class OutputView {
    public void printBoughtLottoCount(int buyAmount){
        System.out.printf("%s개를 구매했습니다.%n", buyAmount);
    }
    public void printLottoNumbers(Lotto lotto) {
        System.out.println(lotto);
    }
    public void printLine(){
        System.out.println();
    }
    public void printLottoResult(){

    }

}
