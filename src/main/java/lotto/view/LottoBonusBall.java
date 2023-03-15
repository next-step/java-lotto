package lotto.view;

import java.util.Scanner;

public class LottoBonusBall {
    private int bonusBall;

    public LottoBonusBall(int bonusBall){
        this.bonusBall = bonusBall;
    }

    public static LottoBonusBall lottoBonusBall(){
        int inputBonusBall;
        Scanner sc = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        inputBonusBall = sc.nextInt();
        return new LottoBonusBall(inputBonusBall);
    }

    public int getBonusBall() {
        return bonusBall;
    }
}
