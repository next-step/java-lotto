/*
 * InputView.java
 *
 * version 1.0
 *
 * 2023/05/01
 *
 * This software is the confidential and proprietary information of Nayoung Kim
 */

package step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    public int enterMoney(){
        int money = 0;

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            money = Integer.parseInt(br.readLine());
            br.close();
        }catch(IOException ie){
            ie.printStackTrace();
        }

        return money;
    }

    public String enterWinningNumbers(){
        String winningNumbers = null;

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            winningNumbers = br.readLine();
            br.close();

        }catch(IOException e){
            e.printStackTrace();
        }

        return winningNumbers;
    }
}
