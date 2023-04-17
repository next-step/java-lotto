package view;

import lotto.LottoTicket;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoInput {

    private int amount;

    private int passiveNumber;

    private List<LottoTicket> lottoPassiveTickets;

    public LottoInput() {
        this.amount = getAmount();
        this.passiveNumber = getPassiveNumber();
        this.lottoPassiveTickets =  inputLottoPassiveTickets();
    }

    public int getAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Scanner(System.in).nextInt();
    }

    public int getPassiveNumber() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return new Scanner(System.in).nextInt();
    }

    private List<LottoTicket> inputLottoPassiveTickets() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        Scanner scan = new Scanner(System.in);
        List<LottoTicket> lottoPassiveObjects = new ArrayList<LottoTicket>();
        for (int i = 0; i < passiveNumber; i++) {
            String passiveNumbersText = scan.nextLine();

            List<Integer> passiveNumbers = Stream.of(passiveNumbersText.split(",")).collect(Collectors.toSet())
                    .stream().map(Integer::parseInt)
                    .collect(Collectors.toList());
            LottoTicket lottoObject = new LottoTicket();
            passiveNumbers.forEach(lottoObject::add);

            lottoPassiveObjects.add(lottoObject);
        }
        return lottoPassiveObjects;
    }

    public List<LottoTicket> getLottoPassiveTickets() {
        return lottoPassiveTickets;
    }


    public  int getTicketCount(){
        return amount/ 1000;
    }

    public  int getActiveTicketCount(int ticketCount){
        return ticketCount - passiveNumber;
    }
    public  void printActivePassiveTicketCount(int ticketCount, int ActiveTicketCount  ){
        System.out.println("수동으로 "+ (ticketCount - ActiveTicketCount)+"장, 자동으로 "+ActiveTicketCount+"개를 구매했습니다.");
    }

    public List<Integer> getWinningNumber() {
        Scanner scan = new Scanner(System.in);

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winingNumbersText = scan.nextLine();
        String[] winning = winingNumbersText.replace(" ", "").split(",");
        return Arrays.stream(winning).map(Integer::parseInt).collect(Collectors.toList());
    }

    public int getBonusNumber() {
        Scanner scan = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요..");
        return scan.nextInt();
    }
}
