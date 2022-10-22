package view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
  public static int paybill(){
    System.out.println("구입금액을 입력해 주세요.");
    Scanner scanner = new Scanner(System.in);
    int payment = scanner.nextInt();
    int amount = payment / 1000;
    System.out.println(amount+"개를 구매했습니다");
    return amount;
  }

  public static List<Integer> winningNums(){
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    Scanner scanner = new Scanner(System.in);
    String winningnumsString= scanner.nextLine();
    String [] winningnumsArrayString = winningnumsString.split(", ");
    int [] winningnumsArray = Stream.of(winningnumsArrayString).mapToInt(Integer::parseInt).toArray();
    List<Integer> winningNums = Arrays.stream(winningnumsArray).boxed().collect(Collectors.toList());
    Collections.sort(winningNums);
    return winningNums;
  }
}
