package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumbers {

    private static final int USER_INPUT_MAX_LENGTH = 3;
    private List<BaseballNumber> baseballNumbers;

    public BaseballNumbers(String baseballNumber) {
        lengthValidate(baseballNumber);
        baseballNumbers = new ArrayList<>();
        for (int i = 0; i < baseballNumber.length(); i++) {
            baseballNumbers.add(new BaseballNumber(String.valueOf(baseballNumber.charAt(i))));
        }
    }

    private void lengthValidate(String baseballNumber) {
        if (baseballNumber.length() > USER_INPUT_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public int getStrikeCount(BaseballRandomNumbers baseballRandomNumbers) {

        int strikeCount = 0;
        List<Integer> randomNumber = baseballRandomNumbers.getRandomNumberToList();
        for (int baseballIndex = 0; baseballIndex < baseballNumbers.size(); baseballIndex++) {
            strikeCount += isStrike(randomNumber.get(baseballIndex),
                    baseballNumbers.get(baseballIndex).toIntegerBaseballNumber());
        }
        return strikeCount;
    }

    public int getBallCount(BaseballRandomNumbers baseballRandomNumbers) {

        int ballCount = 0;
        List<Integer> randomNumber = baseballRandomNumbers.getRandomNumberToList();
        for (int baseballIndex = 0; baseballIndex < baseballNumbers.size(); baseballIndex++) {
            ballCount += isBall(baseballIndex, randomNumber);
        }
        return ballCount;
    }

    private int isStrike(Integer randomNumbers, Integer baseballNumber) {
        if (randomNumbers.equals(baseballNumber)) {
            return 1;
        }
        return 0;
    }

    private int isBall(int indexOfNumbers, List<Integer> randomNumbers) {
        if (randomNumbers.get(indexOfNumbers).equals(baseballNumbers.get(indexOfNumbers).toIntegerBaseballNumber())) {
            return 0;
        }
        if (randomNumbers.contains(baseballNumbers.get(indexOfNumbers).toIntegerBaseballNumber())) {
            return 1;
        }

        return 0;
    }


}
