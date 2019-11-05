package step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LottoMachine {

  private static final int LOTTO_TICKET_PRICE = 1000;
  private static final int SHUFFLE_START_NUMBER = 1;
  private static final int SHUFFLE_END_NUMBER = 45;
  private static final int LOTTO_NUMBER_ARR_SIZE = 6;
  public static int inputAmount;

  public LottoMachine(int inputAmount) {
    this.inputAmount = inputAmount;
  }

  public int calculateTicketCount(int inputAmount) {
    int returnValue = (inputAmount / LOTTO_TICKET_PRICE);
    System.out.println(returnValue + "개를 구매했습니다.");
    return returnValue;
  }

  public ArrayList<String> generateDefaultLottoNumberArr() {
    ArrayList<String> shuffleNumberArr = new ArrayList<>();
    for (int i = SHUFFLE_START_NUMBER; i <= SHUFFLE_END_NUMBER; i++) {
      shuffleNumberArr.add(Integer.toString(i));
    }
    return shuffleNumberArr;
  }

  public ArrayList<String> generateRandomLottoNumberArr(ArrayList<String> defaultLottoNumberArr) {
    ArrayList<String> shffledLottoNumberArr = new ArrayList<>();
    Collections.shuffle(defaultLottoNumberArr);
    for (int i = 0; i < LOTTO_NUMBER_ARR_SIZE; i++) {
      shffledLottoNumberArr.add(defaultLottoNumberArr.get(i));
    }
    return shffledLottoNumberArr;
  }

  public ArrayList<ArrayList<String>> issueLottoNumberArr(int buyTicketCount, ArrayList<String> defaultLottoNumberArr) {
    ArrayList<ArrayList<String>> ticketList = new ArrayList<>();
    ArrayList<String> ticket = new ArrayList<>();

    for (int i = 0; i < buyTicketCount; i++) {
      ticket = generateRandomLottoNumberArr(defaultLottoNumberArr);
      ticketList.add(ticket);
    }

    return ticketList;
  }

  public ArrayList<ArrayList<String>> start() {
    int ticketCount = calculateTicketCount(inputAmount);
    ArrayList<String> defaultLottoNumberArr = generateDefaultLottoNumberArr();
    ArrayList<ArrayList<String>> lottoNumberTicketArr = issueLottoNumberArr(ticketCount,defaultLottoNumberArr);
    printBuyLottoTicketArr(lottoNumberTicketArr);
    return lottoNumberTicketArr;
  }

  private void printBuyLottoTicketArr(ArrayList<ArrayList<String>> lottoNumberTicketArr) {
    for (ArrayList<String> lottoTicket : lottoNumberTicketArr) {
      printBuyLottoTicket(lottoTicket);
    }
  }

  private void printBuyLottoTicket(ArrayList<String> lottoTicket) {
    String[] lottoTicketIntArr = convertStrings(lottoTicket);
    System.out.println(Arrays.toString(lottoTicketIntArr));
  }

  public static String[] convertStrings(ArrayList<String> strs) {
    String[] returnValue = new String[strs.size()];
    for (int i = 0; i < returnValue.length; i++) {
      returnValue[i] = strs.get(i).toString();
    }
    return returnValue;
  }


}
