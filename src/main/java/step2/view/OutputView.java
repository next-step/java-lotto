package step2.view;

import java.util.List;
import step2.domain.LottoNumber;
import step2.domain.Ticket;

public class OutputView {
    public static void printPriceNotification(){
        System.out.println("구매금액을 입력해 주세요");
    }

    public static void printPurchaseResult(int ticketCount){
        System.out.println(ticketCount + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<LottoNumber> lottoNumbers) {
        for (LottoNumber lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber.getLottoNumbers());
        }
        System.out.println();
    }
}
