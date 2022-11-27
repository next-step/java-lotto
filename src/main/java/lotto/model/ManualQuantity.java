package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ManualQuantity {
    private final int manualQuantity;

    public ManualQuantity(int manualQuantity) {
        this(manualQuantity, new Price(1000));
    }

    public ManualQuantity(int manualQuantity, Price price) {
        validation(manualQuantity, price);
        this.manualQuantity = manualQuantity;
    }

    private void validation(int manualQuantity, Price price) {
        if (manualQuantity < 0) {
            throw new IllegalArgumentException("입력 개수를 확인해주세요");
        }
        price.totalMoneyValidation(manualQuantity);
    }

    public List<LottoFactory> manualFactory(Scanner scanner) {
        List<LottoFactory> factories = new ArrayList<>();

        for (int i = 0; i < manualQuantity; i++) {
            String[] split = scanner.nextLine().split(",");
            factories.add(new LottoFactory(new ArrayList<>(Arrays.asList(split))));
        }

        return factories;
    }

    public int restQuantity(Price price) {
        return price.autoQuantity(manualQuantity);
    }

    public int getManualQuantity() {
        return manualQuantity;
    }
}
