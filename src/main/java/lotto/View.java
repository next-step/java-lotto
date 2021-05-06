package lotto;

import java.util.Scanner;

public class View {
    public static void main(String[] args) {
    }

}

class InputView{
    Scanner scanner = new Scanner(System.in);

    public int insertPayMoney(){
        return scanner.nextInt();
    }

    public String insertWinningNumber(){
        return scanner.next();
    }

    public String insertBonusNumber(){
        return scanner.next();
    }

}

class ResultView{
    Scanner scanner = new Scanner(System.in);


}