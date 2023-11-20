package src.view;

import src.domain.GameNumber;
import src.domain.LottoGameNumberGenerator;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class ManualLottoGameNumberGenerator implements LottoGameNumberGenerator {
    @Override
    public Set<GameNumber> gameNumbers() {
        Scanner scanner = new Scanner(System.in);

        return Arrays.stream(scanner.nextLine().replace(" ", "").split(","))
                .map(Integer::parseInt)
                .map(GameNumber::of)
                .collect(Collectors.toSet());
    }
}
