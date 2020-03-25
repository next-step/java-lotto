public class MainApplication {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
////
        String input = "//#\n1#2#3";

        int sum = StringAddCalculator.addString(input);
        System.out.println("합계 : " + sum);
    }
}
