package lotto.view;

import lotto.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInput {
    static Scanner scanner = new Scanner(System.in);

    public long getInput() {
        System.out.println("구입금액을 입력하세요.");
        return scanner.nextLong();
    }

    public ManualCount getManualLottoCount(){
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return new ManualCount(scanner.nextInt());
    }

    public List<LottoNumbers> getManualLottoNumbers(LottoFactory lottoFactory){
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        scanner.nextLine();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int start = 0; start < lottoFactory.manualLottoCount(); start++) {
            lottoNumbers.add(StringToLottoNumbers.of(scanner.nextLine()).lottoNumbers());
        }
        return lottoNumbers;
    }

    public BonusBall getBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new BonusBall(LottoNumber.of(scanner.nextInt()));
    }

    public LottoNumbers getWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return StringToLottoNumbers.of(scanner.nextLine()).lottoNumbers();
    }
}
