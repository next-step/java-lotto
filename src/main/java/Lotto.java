import sun.misc.PostVMInitHook;

import java.util.Scanner;

public class Lotto {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputData = scanner.nextLine();
        System.out.println(StringAddCalculator.splitAndSum(inputData));
    }
}
