package edu.rosehulman.pokerbot;

public class NaiveStrategy extends Strategy {
    @Override
    Action processDeal(Data data) {
        /*switch (data.position()) {
            case 1:
                throw new RuntimeException("FUCK1");
            case 2:
                throw new RuntimeException("FUCK2");
            default:
                return new Action(Action.CALL, 0);
        }*/
        return new Action(Action.CALL, 0);
    }

    @Override
    Action processFlop(Data data) {
        return new Action(Action.CALL, 0);
    }

    @Override
    Action processRiver(Data data) {
        return new Action(Action.CALL, 0);
    }

    @Override
    Action processTurn(Data data) {
        return new Action(Action.CALL, 0);
    }
}
