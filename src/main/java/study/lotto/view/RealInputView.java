package study.lotto.view;


import study.lotto.domain.LottoNumber;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RealInputView implements InputView{


    public BigDecimal inputPurchaseAmount() {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        boolean isRightPrice = false;
        while (!isRightPrice) {
            System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
            input = scanner.next();
            isRightPrice = checkInput(input);
        }
        return BigDecimal.valueOf(Long.parseLong(input));
    }

    private boolean checkInput(String input) {
        return input.chars().allMatch(Character::isDigit) && Long.parseLong(input) >= 1000;
    }

    public String inputWinningLotto() {
        System.out.println(INPUT_WINNING_LOTTO);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public LottoNumber inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        Scanner scanner = new Scanner(System.in);
        return LottoNumber.of(scanner.nextInt());
    }

    public int inputSelfPickLottoCount() {
        System.out.println(INPUT_SELF_PICK_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public List<String> inputSelfPickLotto(int selfPickLottoCount) {
        System.out.println(INPUT_SELF_PICK_LOTTO);
        Scanner scanner = new Scanner(System.in);

        return Stream.generate(scanner::nextLine)
                .limit(selfPickLottoCount)
                .collect(Collectors.toList());
    }
}
