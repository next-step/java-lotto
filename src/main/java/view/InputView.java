package view;

import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthScrollBarUI;

import domain.FirstPlaceLotto;
import domain.Lotto;
import domain.Lottos;

public class InputView {
    public static void printInputView() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printBuyCount(int count) {
        System.out.println(count + "개를 구입했습니다.");
    }

    public static String scanMoney() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String scanFirstLotto() {
        System.out.println("");
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String scanBonusLottoNumer() {
        System.out.println("보너스 볼을 입력해 주세요.");

        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}