package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.LottoNumber;
import lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import spark.utils.StringUtils;

public class ConsoleInput {

    public static long inputPurchaseAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");

        return scanner.nextInt();
    }

    public static LottoList inputManualLottos(final int limitLottoCount) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        LottoList lottoList = new LottoList();

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();

            if (StringUtils.isEmpty(input.trim()) || lottoList.size() == limitLottoCount) {
                break;
            }

            List<LottoNumber> lottoNumbers = new ArrayList<>();

            String[] numbers = input.split(", ");

            for (int i = 0; i < numbers.length; i++) {
                lottoNumbers.add(LottoNumber.of(Integer.parseInt(numbers[i])));
            }

            lottoList.add(new Lotto(lottoNumbers));
        }

        return lottoList;
    }

    public static WinningLotto inputLastWinningNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine();

        String[] numbers = input.split(", ");
        List<LottoNumber> winningNumbers = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            winningNumbers.add(LottoNumber.of(Integer.parseInt(numbers[i])));
        }

        System.out.println("보너스 볼을 입력해 주세요.");
        LottoNumber bonusNumber = LottoNumber.of(scanner.nextInt());

        return new WinningLotto(new Lotto(winningNumbers), bonusNumber);
    }
}
