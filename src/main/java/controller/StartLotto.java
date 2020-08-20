package controller;

import domain.Games;
import domain.Lotto;
import domain.NumberGenerator;
import utility.UserInput;

import java.util.List;

public class StartLotto {
    public static void main(String[] args) {
        int tries = UserInput.init();

        List<Lotto> lottos = Games.makeLottoTicket(tries);

        System.out.println(lottos.size());

        String[] temp = "1,2,3,4,5,6".split(",");

        for (int i = 0; i < lottos.size(); i++) {
            List<Integer> six = lottos.get(i).getSixNumber();

            int count =0;
            for (int j = 0; j < 6; j++) {
                if( six.contains(Integer.parseInt(temp[j]))){
                   count++;
                }
            }
            System.out.println(count);
        }

    }
}
