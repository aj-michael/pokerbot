package edu.rosehulman.pokerbot;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public abstract class Strategy {

    final Action process(Data data) {
        final Map<String, Function<Data, Action>> functions = new HashMap<>();
        functions.put("deal", this::processDeal);
        functions.put("flop", this::processDeal);
        functions.put("river", this::processDeal);
        functions.put("turn", this::processDeal);
        System.out.println(data.betting_phase);
        return functions.get(data.betting_phase).apply(data);
    }

    abstract Action processDeal(Data data);
    abstract Action processFlop(Data data);
    abstract Action processRiver(Data data);
    abstract Action processTurn(Data data);

}
