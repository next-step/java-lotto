package lotto.view;

import lotto.common.MessageCode;
import lotto.domain.LottoNumbers;

import java.util.Scanner;

public class InputView {
    Scanner scan;
    private String inputLastWonLottoNumber;
    private String inputBonusNumber;
    private int inputAmount;

    public InputView() {
        scan = new Scanner(System.in);
    }

    public int inputMoneyForLotto() {
        System.out.println(MessageCode.INPUT_MONEY_FOR_LOTTO.message());
        return scan.nextInt();
    }

    public int inputManualLottoBuyCount() {
        System.out.println(MessageCode.INPUT_MANUAL_BUY_LOTTO_COUNT.message());
        return scan.nextInt();
    }

    public int getInputAmount() {
        return inputAmount;
    }

    public void inputLastWonLottoNumbers() {
        System.out.println(MessageCode.INPUT_LAST_WON_LOTTO_NUMBERS.message());
        inputLastWonLottoNumber = scan.next();
    }

    public String getInputLastWonLottoNumbers() {
        return inputLastWonLottoNumber;
    }

    public String getInputBonusNumber() {
        return inputBonusNumber;
    }

    public void inputBonusLottoNumber() {
        System.out.println(MessageCode.INPUT_LAST_WON_BONUS_NUMBER.message());
        inputBonusNumber = scan.next();
    }

    public LottoNumbers[] inputManualLottoNumbers(int manualBuyLottoCount) {
        String [] manualLottoNumbers = {};
        for(int i=0; i<manualBuyLottoCount; i++)
            manualLottoNumbers[i] = scan.next();

        LottoNumbers[] lottoNumbersArray = new LottoNumbers[manualBuyLottoCount];
        lottoNumbersArray = convertingStringToLottoNumbersArray(manualLottoNumbers);

        return lottoNumbersArray;
    }

    public LottoNumbers[] convertingStringToLottoNumbersArray(String[] manualLottoNumbers) {
        LottoNumbers[] lottoNumbers = new LottoNumbers[manualLottoNumbers.length];

        for(int i=0; i<manualLottoNumbers.length; i++) {
            lottoNumbers[i] = parsingInputLottoNumbers(manualLottoNumbers[i]);
        }

        return lottoNumbers;
    }

    public LottoNumbers parsingInputLottoNumbers(String manualLottoNumbers) {
        String[] stringNumbers = manualLottoNumbers.split(",");
        int[] intNumbers = new int[stringNumbers.length];
        for (int i =0; i<stringNumbers.length; i ++) {
            intNumbers[i] = Integer.parseInt(stringNumbers[i]);
        }
        LottoNumbers lottoNumbers = new LottoNumbers(intNumbers);
        return lottoNumbers;
    }

}
