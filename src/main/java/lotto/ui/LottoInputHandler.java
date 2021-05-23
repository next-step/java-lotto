package lotto.ui;

import lotto.domain.Lottos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoInputHandler {
    public int scanLottoPurchaseBudget() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }

    public int scanCountOfManualLotto() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }

    public List<String> scanManualLottos(int manualCount) {
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> lottosString = new ArrayList<>();
        for (int i = 0; i < manualCount; ++i) {
            try {
                lottosString.add(br.readLine());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return lottosString;
    }

    public String scanLottoWinNumbersString() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    public int scanLottoBonusNumber() {
        System.out.println("\n보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }

}
