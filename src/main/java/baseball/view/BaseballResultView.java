package baseball.view;

import baseball.domain.BaseballRule;

public class BaseballResultView {

    public void printBaseballResult(BaseballRule baseballRule) {

        printBall(baseballRule);
        printStrike(baseballRule);
        printNothing(baseballRule);

    }

    private void printBall(BaseballRule baseballRule) {
        if (baseballRule.getBallCount() > 0) {
            System.out.print(String.format("%d볼 ", baseballRule.getBallCount()));
        }
    }

    private void printStrike(BaseballRule baseballRule) {
        if (baseballRule.getStrikeCount() > 0) {
            System.out.print(String.format("%d스트라이크", baseballRule.getStrikeCount()));
        }
    }

    private void printNothing(BaseballRule baseballRule) {
        if (baseballRule.getStrikeCount() == 0 && baseballRule.getBallCount() == 0) {
            System.out.println("낫싱");
        }
    }

    public boolean getGameResult(BaseballRule baseballRule) {
        if (baseballRule.checkGameOver()) {
            System.out.println("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return true;
        }
        return false;
    }


}
