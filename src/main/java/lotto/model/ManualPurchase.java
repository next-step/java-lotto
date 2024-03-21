package lotto.model;

import lotto.exception.InvalidLottoException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ManualPurchase extends LottoMachine {
    private final Scanner scanner;

    public ManualPurchase(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public List<Lotto> execute(int quantity) {
        if (quantity <= 0) {
            return Collections.emptyList();
        }

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        try {
            return toLottos(quantity);
        } catch (InvalidLottoException e) {
            System.out.println(e.getMessage());
        }

        return execute(quantity);
    }

    private List<Lotto> toLottos(int quantity) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            lottos.add(toLotto());
        }
        
        return lottos;
    }

    private Lotto toLotto() {
        return LottoNumberFactory.of(convertTo(scanner.nextLine()));
    }

    private Integer[] convertTo(String input) {
        return Arrays.stream(input.split(","))
                .mapToInt(this::toInt)
                .boxed()
                .toArray(Integer[]::new);
    }

    private int toInt(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new InvalidLottoException("정수를 입력해 주세요", e);
        }
    }

}
