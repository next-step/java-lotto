package lotto.view;

import lotto.common.Constant;
import lotto.common.MessageCode;
import lotto.domain.LottoNumbers;

import java.util.Scanner;

public class InputView {
    Scanner scan;

    public InputView() {
        scan = new Scanner(System.in);
    }

    public int inputMoneyForLotto() {
        System.out.println(MessageCode.INPUT_MONEY_FOR_LOTTO.message());
        return inputMoneyValidate(scan.nextInt());
    }

    public int inputMoneyValidate(int inputMoney) {
        if (inputMoney < 1000)
            throw new IllegalArgumentException(MessageCode.INVALID_INPUT_MONEY.message());
        return inputMoney;
    }

    public int inputManualLottoBuyCount(int inputMoney) {
        System.out.println(MessageCode.INPUT_MANUAL_BUY_LOTTO_COUNT.message());
        return inputManualLottoBuyCountValidate(scan.nextInt(), inputMoney);
    }

    private int inputManualLottoBuyCountValidate(int buyCount, int inputMoney) {
        if (inputMoney < buyCount * Constant.LOTTO_PRICE.value())
            throw new IllegalArgumentException(MessageCode.INVALID_INPUT_MANUAL_LOTTO_NUMBER.message());
        return buyCount;
    }

    public String inputWinningLottoNumbers() {
        System.out.println(MessageCode.INPUT_WINNING_LOTTO_NUMBERS.message());
        return scan.next();
    }

    public String inputBonusLottoNumber() {
        System.out.println(MessageCode.INPUT_BONUS_NUMBER.message());
        return scan.next();
    }

    public LottoNumbers[] inputManualLottoNumbers(int manualBuyLottoCount) {
        System.out.println(MessageCode.INPUT_MANUAL_LOTTO_NUMBERS.message());
        String[] manualLottoNumbers = new String[manualBuyLottoCount];
        for (int i = 0; i < manualBuyLottoCount; i++)
            manualLottoNumbers[i] = scan.next();

        LottoNumbers[]  lottoNumbersArray = convertingStringToLottoNumbersArray(manualLottoNumbers);
        //validateManualLottoNumbers(manualLottoNumbers);
        return lottoNumbersArray;
    }

    private void validateManualLottoNumbers(String[] manualLottoNumbers) {
        if (manualLottoNumbers.length != 6)
            throw new IllegalArgumentException(MessageCode.INVALID_INPUT_LOTTO_NUMBER_COUNT.message());
    }

    public LottoNumbers[] convertingStringToLottoNumbersArray(String[] manualLottoNumbers) {
        LottoNumbers[] lottoNumbers = new LottoNumbers[manualLottoNumbers.length];

        for (int i = 0; i < manualLottoNumbers.length; i++) {
            lottoNumbers[i] = parsingInputLottoNumbers(manualLottoNumbers[i]);
        }

        return lottoNumbers;
    }

    public LottoNumbers parsingInputLottoNumbers(String manualLottoNumbers) {
        String[] stringNumbers = manualLottoNumbers.split(",");
        int[] intNumbers = new int[stringNumbers.length];
        for (int i = 0; i < stringNumbers.length; i++) {
            intNumbers[i] = Integer.parseInt(stringNumbers[i]);
        }
        LottoNumbers lottoNumbers = new LottoNumbers(intNumbers);
        return lottoNumbers;
    }

}
