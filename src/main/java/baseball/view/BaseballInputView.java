package baseball.view;


import camp.nextstep.edu.missionutils.Console;

public class BaseballInputView {

    private static final String REPLAY_GAME_CHECK_VALUES = "1,2";

    public String inputBaseBallNumber() {
        System.out.print("\n숫자를 입력해 주세요 : ");
        return Console.readLine();
    }

    public boolean checkReplyGame(boolean gameOverYn) {
        if (!gameOverYn) {
            return true;
        }
        String inputValue = Console.readLine();
        checkReplyValidation(inputValue);

        if (inputValue.equals("2")) {
            return false;
        }

        return true;
    }

    private void checkReplyValidation(String inputValue) {
        if (!REPLAY_GAME_CHECK_VALUES.contains(inputValue)) {
            throw new IllegalArgumentException();
        }
    }
}
