package lotto.model;

public class LottoStatic {
    public int buyLottos(int budget) {
        int purchase =  budget / 1000;

        return purchase;
    }

    public int getPrizeMoney(int rank) {
        int prize = 0;
        switch (rank) {
            case 1:
                prize = 2000000000;
                break;

            case 2:
                prize = 1500000;
                break;

            case 3:
                prize = 50000;
                break;

            case 4:
                prize = 5000;
                break;

            default:
                prize = 0;
                break;
        }

        return prize;
    }
}
