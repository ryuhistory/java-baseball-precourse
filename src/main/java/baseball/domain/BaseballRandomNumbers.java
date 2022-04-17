package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseballRandomNumbers {

    private static final int MINIMUM_RANGE = 1;
    private static final int MAXIMUM_RANGE = 9;
    private static final int COUNT_OF_NUMBER = 3;
    private List<Integer> randomNumbersList;

    public BaseballRandomNumbers() {

        generatedNumbers();

    }

    private void generatedNumbers() {
        randomNumbersList = new ArrayList<>();
        while (randomNumbersList.size() < COUNT_OF_NUMBER) {
            addRandomNumber(Randoms.pickNumberInRange(MINIMUM_RANGE, MAXIMUM_RANGE));
        }
    }

    private void addRandomNumber(int randomNumber) {
        if (randomNumbersList.contains(randomNumber)) {
            return;
        }
        randomNumbersList.add(randomNumber);
    }

    public List<Integer> getRandomNumberToList() {
        return Collections.unmodifiableList(randomNumbersList);
    }


    public void checkShuffleNumber(boolean gameContinueFlag, BaseballRule baseballRule) {

        if (!baseballRule.checkGameOver()) {
            return;
        }
        if (!gameContinueFlag) {
            return;
        }

        generatedNumbers();
    }


}
