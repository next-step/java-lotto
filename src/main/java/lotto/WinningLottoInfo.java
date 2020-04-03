package lotto;

import static java.util.stream.Collectors.toSet;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

public class WinningLottoInfo {
    private static final String SPLIT_TEXT = ",";
    private static Scanner scanner = new Scanner(System.in);
    private static WinningLottoInfo winningLottoInfo = new WinningLottoInfo();

    private LottoNo bonusBall;
    private LottoNumbers winningNumbers;

    public WinningLottoInfo() {
    }

    public WinningLottoInfo(int bonusBall, String inputText) {
        this.bonusBall = LottoNo.of(bonusBall);
        Set<LottoNo> numbers = splitWinningNumber(inputText);
        this.winningNumbers = new LottoNumbers(numbers);
        validateBonusBall();
    }

    public LottoNumbers enterWinningNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        String inputText = scanner.next();
        Set<LottoNo> numbers = splitWinningNumber(inputText);
        LottoNumbers winningNumbers = new LottoNumbers(numbers);
        this.winningNumbers = winningNumbers;
        return winningNumbers;
    }

    public LottoNo enterBonusBall() {
        System.out.println("\n보너스 볼을 입력해 주세요");
        LottoNo bonusBall = LottoNo.of(scanner.nextInt());
        this.bonusBall = bonusBall;
        validateBonusBall();
        return bonusBall;
    }

    public void validateBonusBall() {
        if (this.winningNumbers.getNumbers().contains(this.bonusBall)) {
            throw new IllegalArgumentException("당첨번호와 보너스볼이 중복됩니다.");
        }
    }

    private Set<LottoNo> splitWinningNumber(String inputText) {
        return Arrays
                .stream(inputText.split(SPLIT_TEXT))
                .map(num -> new LottoNo(Integer.parseInt(num)))
                .collect(toSet());
    }

    public LottoNo getBonusBall() {
        return bonusBall;
    }

    public LottoNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public static WinningLottoInfo getWinningLottoInfo() {
        return winningLottoInfo;
    }

}
