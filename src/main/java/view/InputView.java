package view;

import java.util.Scanner;

public class InputView {
    public static String getInput(){
        System.out.println("입력 해주세요");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    public static String[] splitByEmptyString(String input) {
        if(input == null || input.replaceAll(" ", "").isEmpty()){
            throw new IllegalArgumentException("input must not empty string");
        }
        if(!input.replaceAll(" ","").replaceAll("[0-9]","").matches("[+\\-*/\\s]+")){
            throw new IllegalArgumentException("input must contain arithmetic characters");
        }
        return input.split(" ");
    }
}
