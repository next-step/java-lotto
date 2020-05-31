package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StringInputScanner {

    private String[] numbersString;

    private void getInputStream() {
        Scanner scanner = new Scanner(System.in);
        this.numbersString  = scanner.nextLine().replace(" ", "").split(",");
    }

    public List<Integer> getNumbers() {
        getInputStream();

        return Arrays.stream(numbersString)
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }
}
