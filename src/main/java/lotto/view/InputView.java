package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private int purchasingAmount = 0;
    private static final int LOTTO_PRICE = 1000;
    private final Scanner scanner = new Scanner(System.in);
    private int totalPurchasingCount = 0;

    public int receivePurchasingAmount() {
        purchasingAmount = scanner.nextInt();
        scanner.nextLine();
        validatePurchasingAmount();
        printBuyLotto();
        totalPurchasingCount = purchasingAmount / 1000;
        return totalPurchasingCount;
    }

    public List<Lotto> receiveManualLotto() {
        int manualPurchasingAmount = receiveManualLottoAmount();
        List<Lotto> lottoNumbers = receiveManualLottoNumbers(manualPurchasingAmount);
        return lottoNumbers;
    }

    public List<LottoNumber> receiveWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine();
        scanner.nextLine();
        validateLottoNumber(input);
        return convertLottoNumber(input);
    }

    public int getPurchasingAmount() {
        return this.purchasingAmount;
    }

    public LottoNumber receiveBonusNo() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int input = scanner.nextInt();
        scanner.nextLine();
        return new LottoNumber(input);
    }

    private List<Lotto> receiveManualLottoNumbers(int manualPurchasingAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < manualPurchasingAmount; i++) {
            System.out.println("수동으로 구매할 번호를 입력해 주세요.");
            String input = scanner.nextLine();
            validateLottoNumber(input);
            lottos.add(chopManualLottoNumbers(input));
        }
        return lottos;
    }

    private Lotto chopManualLottoNumbers(String input) {
        List<LottoNumber> lottoNumbers = convertLottoNumber(input);
        return new Lotto(lottoNumbers);
    }

    private int receiveManualLottoAmount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualPurchasingAmount = scanner.nextInt();
        scanner.nextLine();
        validateManualPurchasingAmount(manualPurchasingAmount);
        return manualPurchasingAmount;
    }

    private void validateManualPurchasingAmount(int manualPurchasingAmount) {
        if (manualPurchasingAmount > totalPurchasingCount) {
            throw new IllegalArgumentException("수동으로 구매할 로또 수가 총 구매한 로또 수보다 많습니다.");
        }
    }

    private void validatePurchasingAmount() {
        if (purchasingAmount / LOTTO_PRICE < 1) {
            throw new IllegalArgumentException("그 돈으로는 로또를 한 장도 살 수 없습니다. 돌아가세요!");
        }
    }

    private void printBuyLotto() {
        System.out.println(purchasingAmount / LOTTO_PRICE + "개를 구매했습니다.");
        printReturnChange();
    }

    private void printReturnChange() {
        if (purchasingAmount % LOTTO_PRICE > 0) {
            System.out.println("거스름돈 " + purchasingAmount % LOTTO_PRICE + "원을 받았습니다.");
        }
    }

    private List<LottoNumber> convertLottoNumber(String input) {
        List<LottoNumber> lottoNumbers = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        lottoNumbers.sort(Comparator.naturalOrder());
        return lottoNumbers;
    }


    private void validateLottoNumber(String input) {
        Set<String> numbers = Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toSet());

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
        }
    }
}
