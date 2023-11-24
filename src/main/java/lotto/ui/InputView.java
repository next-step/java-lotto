package lotto.ui;

import lotto.domain.Lotto;
import lotto.common.LottoGenerator;
import lotto.domain.LottoNumber;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final String DELIMITER_COMMA_EMPTY = "\\s*,\\s*";
    private final int LOTTO_PRICE = 1000;

    public Integer inputAmount() {
        System.out.println("로또 구입 금액을 입력해주세요.");
        Scanner scanner = new Scanner(System.in);
        String amount = scanner.nextLine();
        return Integer.parseInt(amount);
    }

    public List<Lotto> calculateLottos(Integer amount) {
        Integer lottoCount = amount / LOTTO_PRICE;
        System.out.println(lottoCount + "개를 구입했습니다.");
        return generateLottos(lottoCount);
    }

    private List<Lotto> generateLottos(Integer lottoCount) {
        List<Lotto> lottos = LottoGenerator.generateByLottoCount(lottoCount);
        printLottos(lottos);
        return lottos;
    }

    private void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
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
