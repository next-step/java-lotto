package Lotto;


import java.util.Random;

public class LottoPaper {

    private final int LOTTO_NUMBER_BOUND = 45;

    private int[] lottoPaper;

    public LottoPaper() {
        lottoPaper = new int[6];
        makeDeal();
    }

    private int[] makeDeal() {
        Random random = new Random();

        for (int i = 0; i < lottoPaper.length; i++) {
            int ran = random.nextInt(LOTTO_NUMBER_BOUND);
            if (!isContains(lottoPaper, ran)) {
                lottoPaper[i] = ran;
            } else if (isContains(lottoPaper, ran)) {
                i--;
            }
        }


        return lottoPaper;
    }

    public boolean isContains(int[] lottoPaper, int ran) {
        boolean bool = false;

        for (int i = 0; i < lottoPaper.length; i++) {
            if (lottoPaper[i] == ran) {
                bool = true;
                break;
            }
        }

        return bool;
    }

    public int getLength() {
        return lottoPaper.length;
    }

    public int getNumber(int index) {
        return lottoPaper[index];
    }

}
