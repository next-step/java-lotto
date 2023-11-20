package lotto.view;

import lotto.domain.lotto.wrapper.LottoNumber;
import lotto.domain.lotto.wrapper.LottoNumbers;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.*;

public class InputView {

    private static final int LOTTO_PRICE = 1000;
    private static final String DELIMITER = ",";

    private final Scanner sc;
    private final InputValidator inputValidator;

    public InputView() {
        this.sc = new Scanner(in);
        this.inputValidator = new InputValidator();
    }

    public int inputPurchaseMoney() {
        print("구입 금액을 입력해주세요.");

        try {
            String purchase = input();
            inputValidator.validatePurchaseMoney(purchase, LOTTO_PRICE);

            return calculateNumOfLotto(purchase);
        } catch (IllegalArgumentException e){
            print(e.getMessage());
            return inputPurchaseMoney();
        }
    }

    private int calculateNumOfLotto(String purchase) {
        return (int) Long.parseLong(purchase) / LOTTO_PRICE;
    }

    public int inputCountOfManual(int numOfLotto) {
        print("수동으로 구매할 로또 수를 입력해 주세요.");

        try {
            String countOfManual = input();
            inputValidator.validateCountOfManual(countOfManual, numOfLotto);

            return Integer.parseInt(countOfManual);
        } catch (IllegalArgumentException e){
            print(e.getMessage());
            return inputCountOfManual(numOfLotto);
        }
    }

    public List<LottoNumbers> drawNumbersByManual(int countOfManual) {
        print("수동으로 구매할 번호를 입력해 주세요.");

        List<LottoNumbers> lottos = new ArrayList<>();
        inputManualNumbers(lottos, countOfManual);

        return lottos;
    }

    private void inputManualNumbers(List<LottoNumbers> lottos, int countOfManual) {
        if (countOfManual == 0) {
            return;
        }

        try {
            String input = input();
            inputValidator.validateLottoNumbers(input, DELIMITER);
            lottos.add(convertToNumbers(input));
            inputManualNumbers(lottos, countOfManual - 1);
        } catch (IllegalArgumentException e){
            print(e.getMessage());
            inputManualNumbers(lottos, countOfManual);
        }
    }

    public LottoNumbers inputWinningNumbers() {
        print("이번 주 당첨 번호를 입력해 주세요.");

        try {
            String input = input();
            inputValidator.validateLottoNumbers(input, DELIMITER);
            return convertToNumbers(input);
        } catch (IllegalArgumentException e){
            print(e.getMessage());
            return inputWinningNumbers();
        }
    }

    private LottoNumbers convertToNumbers(String input) {
        String[] stringNumbers = input.split(DELIMITER);

        return new LottoNumbers(Arrays.stream(stringNumbers)
            .map(stringNumber -> LottoNumber.of(Integer.parseInt(stringNumber.trim())))
            .collect(Collectors.toUnmodifiableList()));
    }

    public LottoNumber inputBonusNumber(LottoNumbers winningNumbers) {
        print("보너스 볼을 입력해주세요.");

        try {
            String input = input();
            inputValidator.validateBonusNumber(input, winningNumbers);

            return LottoNumber.of(Integer.parseInt(input));
        } catch (IllegalArgumentException e){
            print(e.getMessage());
            return inputBonusNumber(winningNumbers);
        }
    }

    private String input() {
        return sc.nextLine();
    }

    private void print(String message) {
        out.println(message);
    }
}
