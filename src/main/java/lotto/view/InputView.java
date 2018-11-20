package lotto.view;

import lotto.constant.Question;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public abstract class InputView {

    private InputView() {
    }

    public static int IntegerQuestion(final String question) {
        final Scanner scanner = new Scanner(System.in, String.valueOf(StandardCharsets.UTF_8));
        printQuestion(question);
        return scanner.nextInt();
    }

    public static String StringQuestion(final String question) {
        final Scanner scanner = new Scanner(System.in, String.valueOf(StandardCharsets.UTF_8));
        printQuestion(question);
        return scanner.nextLine();
    }

    public static Lottos printManualPurchaseNumber(final int manualPurchaseLottoNumber) {

        if (hasManualPurchaseLottoNumber(manualPurchaseLottoNumber)) {
            printQuestion(Question.PLEASE_ENTER_A_NUMBER_TO_PURCHASE_MANUALLY);
        }

        final Lottos lottos = new Lottos();
        for (int i = 0; i < manualPurchaseLottoNumber; i++) {
            final Scanner scanner = new Scanner(System.in, String.valueOf(StandardCharsets.UTF_8));
            lottos.add(new Lotto(scanner.next()));
        }
        return lottos;
    }

    private static boolean hasManualPurchaseLottoNumber(final int manualPurchaseLottoNumber) {
        return manualPurchaseLottoNumber > 0;
    }

    private static void printQuestion(final String question) {
        System.out.println(question);
    }

}
