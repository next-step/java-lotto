package lotto.ui;

import lotto.common.generator.GeneratorFactory;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.common.handler.UiExceptionHandler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final String DELIMITER_COMMA_EMPTY = "\\s*,\\s*";
    private final int LOTTO_PRICE = 1000;
    UiExceptionHandler exceptionHandler = new UiExceptionHandler();

    public int inputAmount() {
        System.out.println("로또 구입 금액을 입력해주세요.");
        Scanner scanner = new Scanner(System.in);
        String amount = scanner.nextLine();
        if (exceptionHandler.inputAmountHandle(amount)) {
            return inputAmount();
        }
        return Integer.parseInt(amount);
    }

    public int inputManualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String count = scanner.nextLine();
        return Integer.parseInt(count);
    }

    public List<Lotto> calculateManualLottos(Integer endTurn) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> inputLottos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (int turn = 0; turn < endTurn; turn++) {
            inputLottos.add(scanner.nextLine());
        }
        return GeneratorFactory.generate(inputLottos);
    }

    public List<Lotto> calculateAutoLottos(Integer amount) {
        return generateAutoLottos(amount);
    }

    private List<Lotto> generateAutoLottos(Integer lottoCount) {
        List<Lotto> lottos = GeneratorFactory.generate(lottoCount);
        return lottos;
    }

    public void printLottos(Integer manualCount, Integer autoCount, Lottos lottos) {
        System.out.println("");
        System.out.println(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.", manualCount, autoCount));
        for (Lotto lotto : lottos.getLottoList()) {
            printLottoNumber(lotto);
        }
        System.out.println("");
    }

    private void printLottoNumber(Lotto lotto) {
        List<Integer> lottoNumbersForPrint = new ArrayList<>();
        for (LottoNumber number : lotto.getNumbers()) {
            lottoNumbersForPrint.add(number.getLottoNumber());
        }
        lottoNumbersForPrint.sort(Comparator.comparingInt(Integer::intValue));
        System.out.println(lottoNumbersForPrint);
    }

    public Integer inputBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요.");
        Scanner scanner = new Scanner(System.in);
        String bonusNumber = scanner.nextLine();
        System.out.println("");
        return Integer.parseInt(bonusNumber);
    }

    public Lotto inputWinningLotto() {
        System.out.println("당첨 번호를 입력해주세요.");
        Scanner scanner = new Scanner(System.in);
        String winningNumber = scanner.nextLine();
        System.out.println("");
        return convertToLotto(winningNumber);
    }

    private Lotto convertToLotto(String winningNumber) {
        List<Integer> winningLottoNumber = new ArrayList<>(6);
        String[] numbers = winningNumber.split(DELIMITER_COMMA_EMPTY);
        for (String number : numbers) {
            winningLottoNumber.add(Integer.valueOf(number));
        }
        return new Lotto(winningLottoNumber);
    }
}
