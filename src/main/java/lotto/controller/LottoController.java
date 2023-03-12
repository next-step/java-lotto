package lotto.controller;

import lotto.domain.LottoNumber;
import lotto.service.LottoMachine;
import lotto.service.LottoPurchases;
import lotto.service.LottoResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoController {

    private static LottoPurchases lottoPurchasesService;
    private static LottoMachine lottoMachineService;
    private static LottoNumber lottoNumber;

    private static List <LottoNumber> purchasesLottoList = new ArrayList<>();
    private static String previousWeekNumber = "";
    private static int purchasesMoney = 0;
    private static int bonusBall = 0;

    public static List<Integer> numberCheck(String lottoNumber){

        List<Integer> numberList = new ArrayList<>();
        String[] numberSplit = lottoNumber.split(",");


        if(numberSplit == null || numberSplit.length > 6){
            throw new IllegalArgumentException();
        }

        for(String number : numberSplit){
            numberList.add(Integer.parseInt(number));
        }

        return numberList;
    }

    public static LottoNumber numberSet(String previousWeekNumber){
        return new LottoNumber(numberCheck(previousWeekNumber));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("구매금액을 입력해 주세요.");
        purchasesMoney = sc.nextInt();
        lottoPurchasesService = new LottoPurchases(purchasesMoney);

        for (int i = 0; i < lottoPurchasesService.getLottoMachineCount(); i++){
            lottoMachineService = new LottoMachine();
            purchasesLottoList.add(i, lottoMachineService.getLottoNumberList());
        }

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        previousWeekNumber = sc.next();
        lottoNumber = numberSet(previousWeekNumber);

        System.out.println("보너스 볼을 입력해 주세요.");
        bonusBall = sc.nextInt();

        new LottoResult(purchasesLottoList, lottoNumber, purchasesMoney, bonusBall);
    }
}
