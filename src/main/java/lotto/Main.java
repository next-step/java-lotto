package lotto;

import lotto.domain.Buyer;
import lotto.domain.ResultDTO;
import lotto.view.ResultView;
import lotto.view.ScannerView;

import java.util.List;

public class Main {
    public static void main(String args[]){


    NumberInputScanner numberInputScanner = new NumberInputScanner();
    StringInputScanner stringInputScanner = new StringInputScanner();
    ScannerView scannerView = new ScannerView();
    ResultView resultView = new ResultView();

    scannerView.view("구입금액을 입력해 주세요.");

    int money = numberInputScanner.getNumber();
    Buyer buyer = new Buyer(money);
    buyer.buyAutoLotto();

    scannerView.view(buyer.getLottoCount() + "개를 구매했습니다.");
    scannerView.view(buyer.getLottoListNumber());

    scannerView.view("지난 주 당첨 번호를 입력해 주세요.");
    List<Integer> winningNumbers = stringInputScanner.getNumbers();

    buyer.checkLotto(winningNumbers);
    List<Integer> winningList = buyer.checkWin();

    ResultDTO resultDTO = new ResultDTO(money, winningList);
    resultView.view(resultDTO);



    }

}
