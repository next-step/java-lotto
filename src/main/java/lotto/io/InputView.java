package lotto.io;

import lotto.domain.Order;
import lotto.domain.WinningLotto;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

    public static Order getOrder() {
        return new Order.Builder()
                .payment(inputPayment())
                .selfNumber(InputSelfLottoNumber())
                .build();
    }

    private static int inputPayment() {
        System.out.println("구입금액을 입력해 주세요");
        return inputInt();
    }

    private static List<String> InputSelfLottoNumber() {

        int selfLottoCount = inputSelfLottoCount();

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        return IntStream.range(0, selfLottoCount)
                .mapToObj(i -> inputString())
                .collect(Collectors.toList());
    }

    private static int inputSelfLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return inputInt();
    }

    public static WinningLotto getWinningLotto() {
        return WinningLotto.of(inputWinningNumber(), inputBonusBall());
    }

    private static String inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return inputString();
    }

    private static int inputBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return inputInt();
    }


    private static String inputString() {
        return new Scanner(System.in).nextLine();
    }

    private static int inputInt() {
        return new Scanner(System.in).nextInt();
    }
}
