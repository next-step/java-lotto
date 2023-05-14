import step2.domain.LottoMachine;
import step2.domain.LottoNumbers;
import step2.view.InputView;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) { // 1 + 2 * 3 / 2

        int inputCost = InputView.inputCost();
        System.out.println("inputCost = " + inputCost);

        LottoMachine machine = new LottoMachine();
//        LottoNumbers oneLotto = machine.createLottoNumbers(inputCost);

//        for (int i = 0; i < 6; i++) {
//            System.out.println("oneLotto.getLottoNumbers().get(i).getNumber() = " + oneLotto.getLottoNumbers().get(i).getNumber());
//        }

        ArrayList<LottoNumbers> userLottoNumbers = machine.createUserLottoNumbers(inputCost);

        for (int i = 0; i < machine.count(); i++) {
            LottoNumbers oneLotto = userLottoNumbers.get(i);
            //System.out.println("oneLotto.getLottoNumbers().get(i).getNumber() = " + oneLotto.getLottoNumbers().get(i).getNumber());

            for (int j = 0; j < 6; j++) {
                System.out.println("oneLotto.getLottoNumbers().get(i).getNumber() = " + oneLotto.getLottoNumbers().get(j).getNumber());

            }
        }

//        Calculator calculator = new Calculator(InputView.insert());
//        calculator.init();
//        calculator.printResult();
    }
}
