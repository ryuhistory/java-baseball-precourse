package baseball.domain;

public class BaseballNumber {

    private static final int MINIMUM_RANGE = 1;
    private static final int MAXIMUM_RANGE = 9;
    private final String userInputNumbers;

    public BaseballNumber(String userInputNumbers) {
        nullValidation(userInputNumbers);
        numberValidation(userInputNumbers);
        numberRangeValidation(userInputNumbers);
        this.userInputNumbers = userInputNumbers;
    }

    private void nullValidation(String userInputNumbers) {
        if (userInputNumbers == null || userInputNumbers.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void numberValidation(String userInputNumbers) {
        if (!userInputNumbers.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
    }

    private void numberRangeValidation(String userInputNumbers) {
        int inputNumber = Integer.parseInt(userInputNumbers);
        if (inputNumber < MINIMUM_RANGE) {
            throw new IllegalArgumentException();
        }
        if (inputNumber > MAXIMUM_RANGE) {
            throw new IllegalArgumentException();
        }
    }

    public int toIntegerBaseballNumber() {
        return Integer.parseInt(userInputNumbers);
    }

}
