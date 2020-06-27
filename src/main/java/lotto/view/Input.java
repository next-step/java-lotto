package lotto.view;


import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Input {

    private static final Scanner scanner = new Scanner(System.in);
    private static final int INIT_ZERO = 0;

    private Input() {
    }

    public static Money inputMoney() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            int inputMoney = scanner.nextInt();
            return new Money(inputMoney);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputMoney();
        }
    }


    public static WinningLotto inputLastWinningNumber() {

        try {
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            Lotto wininglotto = new Lotto(inputNumbers());
            return inputLastBonusNumber(wininglotto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputLastWinningNumber();
        }
    }

    public static WinningLotto inputLastBonusNumber(Lotto wininglotto) {

        try {
            System.out.println("보너스 번호를 입력해주세요.");
            int inputBonusNumber = scanner.nextInt();
            return new WinningLotto(wininglotto, new LottoNumber(inputBonusNumber));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputLastBonusNumber(wininglotto);
        }

    }

    public static Boolean isEmptyOrBlank(String inputName) {
        return inputName == null || inputName.trim().isEmpty();
    }

    public static int inputSelectLottoCount() {

        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<Lotto> inputSelectLottonumber(LottoGame lottoGame) {

        List<Lotto> selectLottos = new ArrayList<Lotto>();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        int count = INIT_ZERO;
        try {
            for (count = 0; count < lottoGame.getSelectGame(); count++) {
                Lotto lotto = new Lotto(inputNumbers());
                selectLottos.add(lotto);
            }
        } catch (Exception error) {
            System.out.println(error.getMessage());
            LottoGame retryInputLotto = new LottoGame(lottoGame.getTotalGame(), lottoGame.getSelectGame() - count);
            selectLottos.addAll(inputSelectLottonumber(retryInputLotto));
        }

        return selectLottos;
    }

    private static String inputNumbers() {
        try {
            String inputLastWinningNumber = scanner.next();

            if (isEmptyOrBlank(inputLastWinningNumber)) {
                throw new IllegalArgumentException("값이 입력되지 않았습니다.");
            }
            return inputLastWinningNumber;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputNumbers();
        }

    }
}
