package baseball;

import baseball.domain.BaseballNumbers;
import baseball.domain.BaseballRandomNumbers;
import baseball.domain.BaseballRule;
import baseball.view.BaseballInputView;
import baseball.view.BaseballResultView;

public class Application {

    public static void main(String[] args) {

        boolean GAME_CONTINUE_FLAG = true;

        BaseballRandomNumbers baseballRandomNumbers = new BaseballRandomNumbers();
        BaseballInputView baseballInputView = new BaseballInputView();
        BaseballResultView baseballResultView = new BaseballResultView();

        BaseballRule baseballRule = new BaseballRule();

        while (GAME_CONTINUE_FLAG) {
            BaseballNumbers baseballNumbers = new BaseballNumbers(baseballInputView.inputBaseBallNumber());

            baseballRule.addStrikeCount(baseballNumbers.getStrikeCount(baseballRandomNumbers));
            baseballRule.addBallCount(baseballNumbers.getBallCount(baseballRandomNumbers));
            baseballResultView.printBaseballResult(baseballRule);

            GAME_CONTINUE_FLAG = baseballInputView.checkReplyGame(baseballResultView.getGameResult(baseballRule));

            baseballRandomNumbers.checkShuffleNumber(GAME_CONTINUE_FLAG, baseballRule);
            baseballRule.initializeBaseballCount();
        }


    }

}
