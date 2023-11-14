package lotto.view;

import lotto.domain.LottoGame;
import lotto.domain.wrapper.Numbers;
import lotto.util.LottoNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class InputView {

    public static final int LOTTO_PRICE = 1000;

    private Scanner sc = new Scanner(System.in);
    private InputValidator inputValidator;
    private LottoGame lottoGame;

    public InputView(LottoGame lottoGame) {
        this.inputValidator = new InputValidator();
        this.lottoGame = lottoGame;
    }

    public void askPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요");
        String purchase = validateInput();

        List<Numbers> numberses = printResult(purchase);
        lottoGame.createLottos(numberses);
    }

    private String validateInput() {
        String purchase = sc.next();
        inputValidator.validatePurchaseMoney(purchase, LOTTO_PRICE);
        return purchase;
    }

    private List<Numbers> printResult(String purchase) {
        int numOfPurchase = calculateNumOfPurchase(purchase);
        printNumOfPurchase(numOfPurchase);

        return printLottoNumbersDrawed(numOfPurchase);
    }

    private void printNumOfPurchase(int numOfPurchase) {
        System.out.println(numOfPurchase + "개를 구매했습니다.");
    }

    private int calculateNumOfPurchase(String purchase) {
        return (int) Long.parseLong(purchase) / LOTTO_PRICE;
    }

    private List<Numbers> printLottoNumbersDrawed(int numOfPurchase) {
        List<Numbers> numberses = new ArrayList<>();

        IntStream.range(0, numOfPurchase)
            .forEach(i -> {
                Numbers numbers = LottoNumber.drawLottoNumbers();
                numberses.add(numbers);
                System.out.println("[" + numbers.toString() + "]");
            });

        return numberses;
    }
}
