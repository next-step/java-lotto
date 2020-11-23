package lotto.view;

import lotto.LottoTickets;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private int tickets;

    public int buyLotto(){
        Scanner input = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        int price = input.nextInt();

        tickets = price / 1000;
        System.out.println(tickets+"개를 구매했습니다.");

        return tickets;

    }
    //티켓 하나를 로또라는 객체로 생성하기
    //즉  ArrayList<Lotto> 구조로 만들기

    //로또 번호 생성기
    //로또 티켓 객체
    //로또 번호 검사기(당첨 여부)
    //프로세스 확인
    // 구입,티켓개수 확인, 번호 생성, 지난주 당첨번호 입력, 당첨 확인, 당첨 통계

    public void printLottoNumbers(LottoTickets lottoTickets) {

        for(int i=0;i<lottoTickets.getTicketCount();i++){
            System.out.println(lottoTickets.oneOf(i).getTicketNumbers());
        }


    }
    public List<Integer> inputPreWinningNumber(){
        Scanner input = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String preWinningNumber = input.nextLine();

        String[] numbers = preWinningNumber.split(",");
        List<Integer> preNumbers = new ArrayList<>();

        for( String number : numbers){
            preNumbers.add(Integer.parseInt(number.trim()));
        }
        return preNumbers;
    }


}
