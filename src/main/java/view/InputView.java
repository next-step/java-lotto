package view;

import domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static int getInputNumber(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }

    public static String getInputString(String message) {
        if(!message.isEmpty()) {
            System.out.println(message);
        }
        return scanner.next();
    }


    public static List<Lotto> manual(int manualCount) {
        System.out.println("수동으로 구매할 번호를 입력해주세요.");
        List<Lotto> manualLottos = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            manualLottos.add(Lotto.manual(InputView.getInputString("")));
        }
        return manualLottos;
    }
}
