package lotto.step4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<List<Integer>> lottos = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            List<Integer> lotto = Arrays.stream(line.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            lottos.add(lotto);
        }

        System.out.println(a);
        System.out.println(lottos);
    }
}
