package utility;

import java.util.Scanner;

public class UserInput {

    private static final String INIT_MESSEGE= "구입금액을 입력해 주세요.";

    public static int init() {
        System.out.println(INIT_MESSEGE);
        Scanner sc = new Scanner(System.in);
        int price = sc.nextInt();

        validatePrice(price);

        return price/1000;
    }

    private static void validatePrice(int price){
        if(price % 1000 != 0){
           throw new IllegalArgumentException("Price ERR!");
        }

    }

}
