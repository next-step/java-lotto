package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static int inputNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int[] inputWinningNumber() {
        Scanner scanner = new Scanner(System.in).useDelimiter(",");
        return Arrays.stream(scanner.nextLine().replaceAll(" ", "").split(",")).mapToInt(Integer::parseInt).toArray();
    }

    public static List<LottoNumbers> inputManualLottoNumbers(int count) {
        List<LottoNumbers> inputedNumber = new ArrayList<LottoNumbers>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < count; i++) {
            inputedNumber.add(createLottoNumber(scanner.next(), scanner));
        }
        return inputedNumber;
    }

    public static LottoNumbers createLottoNumber(String inputNubmers, Scanner scanner) {
        try {
            return new LottoNumbers(inputNubmers.split(","));
        } catch (Exception e) {
            System.out.println(e.getMessage().toString());
            System.out.println("로또 번호를 다시 입력하십시오");
            return createLottoNumber(scanner.next(), scanner);
        }
    }
}
