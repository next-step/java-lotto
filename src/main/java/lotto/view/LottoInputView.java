package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoNumber;
import lotto.model.domain.Lottos;

public final class LottoInputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private LottoInputView() {
    }

    private static class LottoInputViewHolder {

        private static final LottoInputView INSTANCE = new LottoInputView();


    }

    public static LottoInputView getInstance() {
        return LottoInputViewHolder.INSTANCE;
    }

    public int inputMoney() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            return inputInt();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입 금액이 올바르지 않습니다. 구입금액은  1000 이상의 정수여야합니다.");
        }
    }

    public int inputManualLottoNumber() {
        // TODO 수동 개수
        try {
            System.out.println();
            System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
            return inputInt();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "올바르지 않은 입력입니다. 수동으로 구매할 로또의 개수는 0 이상의 정수이고 전체 로또 개수보다 적어야합니다.");
        }
    }

    public Lottos inputManualLottoNumbers(int manualLottoCount) {
        // TODO 수동 입력
        try {
            System.out.println();
            System.out.println("수동으로 구매할 번호를 입력해 주세요.");
            List<Lotto> manualLottoNumbers = IntStream.range(0, manualLottoCount)
                    .mapToObj(index -> inputLotto()).collect(Collectors.toList());
            return new Lottos(manualLottoNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바르지 않은 입력입니다. ','로 구분하여 6개의 로또 번호를 입력해주세요.");
        }
    }

    public Lotto inputWinningNumbers() {
        try {
            System.out.println();
            System.out.println("지난 주 당첨 번호를 입력해 주세요. ','로 구분하여 6개를 입력해주세요.");
            return inputLotto();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바르지 않은 입력입니다.");
        }
    }

    public LottoNumber inputBonusBall() {
        try {
            System.out.println("보너스 볼을 입력해 주세요.");
            return LottoNumber.of(inputInt());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바르지 않은 입력입니다. 1과 45사이의 정수를 입력하세요.");
        }
    }

    private static int inputInt() throws NumberFormatException {
        return Integer.parseInt(SCANNER.nextLine().strip());
    }

    private static Lotto inputLotto() throws NumberFormatException {
        return new Lotto(Arrays.stream(SCANNER.nextLine().split(","))
                .map(number -> Integer.parseInt(number.strip()))
                .collect(Collectors.toUnmodifiableList()));
    }
}
