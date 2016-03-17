package edu.rosehulman.pokerbot;

public class CactusKevStrategy extends Strategy {
    @Override
    Action processDeal(Data data) {
        return new Action(Action.CALL, 0);
    }

    @Override
    Action processFlop(Data data) {
        return new Action(Action.CALL, 0);
    }

    @Override
    Action processRiver(Data data) {
        try {
            String[] cards = {data.hand[0], data.hand[1], data.community_cards[0], data.community_cards[1], data.community_cards[2]};
            double value = CactusKev.handStrength(cards);
            int idealBet = (int) (value * data.initial_stack);
            if (idealBet < data.call_amount) {
                return new Action(Action.FOLD, 0);
            } else if (idealBet > data.stack) {
                return new Action(Action.RAISE, data.stack);
            } else {
                return new Action(Action.RAISE, idealBet);
            }
        } catch (IndexOutOfBoundsException e) {
            return new Action(Action.CALL, 0);
        }
    }

    @Override
    Action processTurn(Data data) {
        return new Action(Action.CALL, 0);
    }
}
