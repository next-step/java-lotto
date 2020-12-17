package lotto.view;

import lotto.LottoWinCalculator;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_LOTTO_NUMBER_DELIMITER = ",";

    private final Scanner scanner = new Scanner(System.in);

    /**
     * 지불 금액을 입력받아 로또를 몇 개 발급 받을 수 있는지 반환합니다.
     * @return
     */
    public int getAutoLottoCount() {
        System.out.println("구입금액을 입력해 주세요.");
        return this.calculateLottoAmountFromInsertSum(Integer.parseInt(this.scanner.nextLine()));
    }

    /**
     * 입력한 금액으로 로또를 몇 개 발급 받을 수 있는지 계산합니다.
     * 몫으로만 계산합니다.
     * @param sum
     * @return
     */
    private int calculateLottoAmountFromInsertSum(int sum) {
        return sum / LottoWinCalculator.LOTTO_PRICE;
    }


    /**
     * 수동으로 로또를 얼마나 발급받을지 입력받습니다.
     * @return
     */
    public int getManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(this.scanner.nextLine());
    }

    /**
     * 수동으로 로또 번호를 발급합니다.
     * @param lottoCount
     * @return
     */
    public Lottos getManualLottos(int lottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        Lottos lottos = new Lottos();
        for (int i = 0; i < lottoCount; i++) {
            lottos.addLotto(this.getNewLottoByinsertLottoNumber());
        }
        return lottos;
    }

    /**
     * 당첨번호를 입력받습니다.
     * @return
     */
    public Lotto insertWinLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return this.getNewLottoByinsertLottoNumber();
    }

    /**
     * 입력한 로또번호들로 새로운 로또를 발급합니다.
     * @return
     */
    private Lotto getNewLottoByinsertLottoNumber() {
        return new Lotto(Arrays.stream(this.scanner.nextLine().split(InputView.INPUT_LOTTO_NUMBER_DELIMITER))
                .map(input -> Integer.parseInt(input.trim()))
                .collect(Collectors.toList()));
    }

    /**
     * 보너스 번호를 입력받습니다.
     * @return
     */
    public int insertBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return this.scanner.nextInt();
    }
}
