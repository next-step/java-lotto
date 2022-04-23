package lotto.view;

import static lotto.domain.LottoTicket.ONE_TICKET_LOTTO_NUMBER;
import static lotto.domain.LottoTicket.ONE_TICKET_PRICE;

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

        if (buyingBudget <= 0 || buyingBudget % ONE_TICKET_PRICE != 0) {
            System.out.println("로또 구입 금액은 0 이상, "+
                ONE_TICKET_PRICE+"원 배수단위여야 합니다.");
            inputLottoBuyingBudget();
        }

        return buyingBudget;
    }

    public List<Integer> inputWinLottoNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String lottoNumberString = scanner.nextLine();
        List<Integer> lottoNumbers = Arrays.stream(lottoNumberString.replaceAll(" ", "").split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        if (lottoNumbers.size() != ONE_TICKET_LOTTO_NUMBER) {
            System.out.println("로또 당첨 숫자는 "
                +ONE_TICKET_LOTTO_NUMBER+"개 입력해야 합니다.");
            System.out.println("다시 입력, ex) 1,2,3,4,5,6 ");
            inputWinLottoNumber();
        }

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
