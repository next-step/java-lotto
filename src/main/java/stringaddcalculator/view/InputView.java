package stringaddcalculator.view;

import java.util.Scanner;

public class InputView {

    public String input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("수식을 입력하세요");

        //(예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
        String value = sc.nextLine();

        // String value = "//;\n1;2;3";
        sc.close();
        return value;
    }
}
