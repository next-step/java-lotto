package view;

import domain.LottoNumber;
import domain.LottoNumbers;
import domain.LottoResultRequest;
import domain.Money;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import util.BufferedReaderUtil;
import util.CreateAutoNumberMachine;

public class InputView {

    private List<String> winNumbers;
    private List<LottoNumbers> manualLottoNumbers = new ArrayList<>();

    public InputView(){
    }

    public Money buyLotto(){
        System.out.println("구입금액을 입력해 주세요.");
        int buyMoney = Integer.parseInt(BufferedReaderUtil.readLine());
        stickLotto();
        Money money = new Money(buyMoney, manualLottoNumbers.size());
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.%n", manualLottoNumbers.size(), money.getTicketCount());
        return money;
    }

    public List<LottoNumbers> stickLotto() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualCount = Integer.parseInt(BufferedReaderUtil.readLine());
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        getManualLottoNumbers(manualCount);
        System.out.println();
        return manualLottoNumbers;
    }

    private void getManualLottoNumbers(int manualCount) {
        for(int count = 0; count < manualCount; count++){
            String[] list = BufferedReaderUtil.readLine().split(",");
            List<LottoNumber> lottoNumbers = Arrays
                .stream(list)
                .map(str -> new LottoNumber(Integer.parseInt(str)))
                .collect(Collectors.toList());
            this.manualLottoNumbers.add(new LottoNumbers(lottoNumbers));
        }
    }

    public void findWinNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        this.winNumbers = Arrays.asList(BufferedReaderUtil.readLine().split(","));
    }

    public List<LottoNumbers> findStickLottoNumbers() {
        return this.manualLottoNumbers;
    }

    public LottoNumber addBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int number = Integer.parseInt(BufferedReaderUtil.readLine());
        return new LottoNumber(number);
    }

    public LottoResultRequest convert(){
        return new LottoResultRequest(getWinNumbers(), this.addBonusNumber());
    }

    public LottoNumbers getWinNumbers() {
        return
            CreateAutoNumberMachine
                .createNumbers(
                    winNumbers
                    .stream()
                    .mapToInt(Integer::parseInt)
                    .boxed()
            .collect(Collectors.toList()));
    }
}
