package lotto.view;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = ",";

    public static int readAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static int readSelectedLottoCount(){
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static List<List<LottoNumber>> readSelectedLottoNumbers(int selectedLottoCount){
        List<List<LottoNumber>> selectedLottoNumbers = new ArrayList<>();

        if (selectedLottoCount == 0) {
            return selectedLottoNumbers;
        }

        System.out.println("\n수동으로 구매할 번호를 입력해 주세요 (쉼표(,)를 기준으로 구분).");
        for (int i=0; i<selectedLottoCount; i++) {
            selectedLottoNumbers.add(toLottoNumber(splitByComma(SCANNER.next())));
        }

        return selectedLottoNumbers;
    }

    public static List<LottoNumber> readWinningNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요 (쉼표(,)를 기준으로 구분).");
        return toLottoNumber(splitByComma(SCANNER.next()));
    }

    public static int readBonusNumber() {
        System.out.println("\n보너스 볼을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    private static List<LottoNumber> toLottoNumber(List<String> inList) {
        return inList.stream()
                .map(s -> new LottoNumber(Integer.parseInt(s)))
                .collect(Collectors.toList());
    }

    private static List<String> splitByComma(String input) {
        return new ArrayList(Arrays.asList(input.split(DELIMITER)));
    }

}