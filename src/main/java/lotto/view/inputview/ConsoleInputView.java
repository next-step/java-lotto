package lotto.view.inputview;

import lotto.domain.ManualLottoNumbers;
import lotto.domain.NumberOfManualLotto;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ConsoleInputView implements InputView {
    private static final String DELIMITER = ",";

    private final Scanner scanner;

    public ConsoleInputView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int getAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    @Override
    public Set<Integer> getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return getLottoNumbers();
    }

    private Set<Integer> getLottoNumbers() {
        String lottoNumbers = scanner.nextLine();

        return Arrays.stream(lottoNumbers.split(DELIMITER))
                .map(Integer::valueOf)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    @Override
    public int getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    @Override
    public int getNumberOfManualLotto() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    @Override
    public ManualLottoNumbers getManualLottoNumbers(NumberOfManualLotto numberOfManualLotto) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return ManualLottoNumbers.as(numberOfManualLotto, this::getLottoNumbers);
    }

    @Override
    public void printInputError(Exception e) {
        System.out.println(e.getMessage());
    }
}
