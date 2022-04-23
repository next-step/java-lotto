package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

public class CommandlineUserInterface {

    public int inputLottoBuyingBudget() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        int buyingBudget = scanner.nextInt();

        // 1000 의 배수여야 함

        return buyingBudget;
    }

    public List<Integer> inputWinLottoNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String lottoNumberString = scanner.nextLine();
        List<Integer> lottoNumbers = Arrays.stream(lottoNumberString.replaceAll(" ", "").split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        // 6개여야 함 (로또 숫자 정해진 개수)

        System.out.println(lottoNumberString);
        return lottoNumbers;
    }

    public void printLottoTickets(LottoTickets lottoTickets) {
        List<LottoTicket> lottoTickets1 = lottoTickets.getLottoTickets();
        for (LottoTicket lottoTicket : lottoTickets1) {
            System.out.println("lottoTicket = " + lottoTicket);
        }
    }

    public void print(List<LottoResult> lottoResults) {
        System.out.println("lottoResults = " + lottoResults);
    }

}
