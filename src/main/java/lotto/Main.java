package lotto;

import lotto.domains.LottoMachine;

public class Main {
    public static void main(String[] args){
        LottoMachine lottoMachine = new LottoMachine();

        lottoMachine.buyLottos();
        System.out.println();
        lottoMachine.inputWinningNumber();
        System.out.println();
        lottoMachine.printStatistics();
    }
}
