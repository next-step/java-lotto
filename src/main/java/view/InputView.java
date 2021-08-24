package view;

import domain.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String enterString() {
        return SCANNER.next();
    }

    public static int[][] enterManualLotto(int manualLottoCount) {
        int[][] manualLottos = new int[manualLottoCount][LottoNumbers.LOTTO_NUM_COUNT];
        for (int i = 0; i < manualLottoCount; i++) {
            validateManualLotto(manualLottos, i);
        }
        return manualLottos;
    }

    private static void validateManualLotto(int[][] manualLottos, int index) {
        while (true) {
            try {
                String[] lottoNumberArray = enterString().split(",");
                convertStringArrayToIntArray(lottoNumberArray, manualLottos[index]);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private static void convertStringArrayToIntArray(String[] lottoNumberArray, int manualLotto[]) {
        if (lottoNumberArray.length != LottoNumbers.LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("잘못된 로또 값을 입력하였습니다. 6개의 숫자를 입력해주세요.");
        }
        for (int i = 0; i < lottoNumberArray.length; i++) {
            manualLotto[i] = Integer.parseInt(lottoNumberArray[i]);
        }
    }

    public static int enterNumber() throws InputMismatchException {
        int number;
        while (true) {
            try {
                number = SCANNER.nextInt();
                return number;
            } catch (InputMismatchException e) {
                System.out.println("숫자가 아닌 값을 입력하였습니다");
                SCANNER.next();
            }
        }
    }

    public static WinningLotto enterWinningLotto() {
        WinningLotto winningLotto;
        while (true) {
            try {
                System.err.println("지난 주 당첨 번호를 입력해 주세요.");
                int winningLottos[][] = enterManualLotto(WinningLotto.WINNING_LOTTO_COUNT);
                Lotto lotto = LottoManager.makeLotto(new ManualNumberStrategy(winningLottos[0]));
                System.err.println("보너스 볼을 입력해 주세요.");
                LottoNumber bonusLottoNumber = LottoManager.makeLottoNumber(InputView.enterNumber());
                winningLotto = new WinningLotto(lotto, bonusLottoNumber);
                return winningLotto;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
