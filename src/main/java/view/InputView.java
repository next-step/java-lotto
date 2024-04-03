package view;

import domain.lotto.vo.LottoNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

  private final Scanner scanner;

  public InputView() {
    this.scanner = new Scanner(System.in);
  }

  public int inputInteger() {
    int input = scanner.nextInt();
    scanner.nextLine();
    return input;
  }

  public List<LottoNumber> inputLottoNumberList() {
    return Arrays.stream(scanner.nextLine().split(","))
        .map(String::trim)
        .map(Integer::parseInt)
        .map(LottoNumber::of)
        .collect(Collectors.toList());
  }

  public List<List<LottoNumber>> inputManualLottoNumberList(int count){
    List<List<LottoNumber>> manualLottoNumberList = new ArrayList<>();
    for(int i = 0 ; i < count ; i++){
      manualLottoNumberList.add(inputLottoNumberList());
    }
    return manualLottoNumberList;
  }
}
