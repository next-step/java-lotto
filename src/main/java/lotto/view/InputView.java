package lotto.view;

import static lotto.util.LottoStringUtil.splitStringToIntegerList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lotto.domain.LottoNumber;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public List<LottoNumber> inputLastWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String numberString = scanner.nextLine();
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        List<Integer> numbers = splitStringToIntegerList(numberString);
        for (Integer number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return lottoNumbers;
    }

    public int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }

}
