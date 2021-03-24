package calculator.view;

import java.util.Scanner;

public class InputView {
    public String getInput(){
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNext()){
            return scanner.nextLine();
        }
        throw new IllegalStateException("입력을 받을 수 없습니다.");
    }
}
