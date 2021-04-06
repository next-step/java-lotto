package view;

import domain.LottoNumber;
import domain.LottoNumbers;
import domain.Money;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import util.CreateAutoNumberMachine;

public class InputView {

    private List<String> winNumbers;

    public InputView(){
    }

    public Money buyLotto(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        Money money = new Money(Integer.parseInt(scanner.nextLine()));
        System.out.println(money.getTicketCount() +"개를 구매했습니다.");
        return money;
    }

    public void findWinNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        this.winNumbers = Arrays.asList(scanner.nextLine().split(","));
    }

    public LottoNumber addBonusNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        int number = Integer.parseInt(scanner.nextLine());
        return new LottoNumber(number);
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
