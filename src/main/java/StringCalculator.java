import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public String input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public int zero() {
        return 0;
    }
    public int one(String text) {
        int number = Integer.parseInt(text);
        return number;
    }
    public int two(String text) {
        String[] numbers = text.split(",");
        return sum(numbers);
    }

    private int sum(String[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            int num = Integer.parseInt(numbers[i]);
            sum += num;
        }
        return sum;
    }

    public int colone(String text) {
        String[] tokens= text.split(",|:");
        return sum(tokens);
    }
    public int custom(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        int sum=0;
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            sum = sum(tokens);
        }
        return sum;
    }
    public int add(String text) {
        int num=0;
        if (text == null) {
            num = zero();
            return num;
        }
        if (text.isEmpty()) {
            num = zero();
        }
        if (text.length() == 1) {
            num = one(text);
        }
        if (text.contains(",")&&!text.contains(":")) {
            num = two(text);
        }
        if (text.contains(":") && text.contains(",")){
            num = colone(text);
        }
        if (text.contains("//")&&text.contains(("\n"))){
            num = custom(text);
        }
        if (text.contains("-")) {
            throw new RuntimeException();
        }
        return num;
    }
}
