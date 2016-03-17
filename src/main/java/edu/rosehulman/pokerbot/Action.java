package edu.rosehulman.pokerbot;

import com.google.gson.JsonObject;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class Action {
    static final String BET = "bet";
    static final String RAISE = "raise";
    static final String CALL = "call";
    static final String CHECK = "check";
    static final String FOLD = "fold";

    String action;
    int amount;

    Action(String action, int amount) {
        this.action = action;
        this.amount = amount;
    }

    RequestBody toRequest() {
        JsonObject obj = new JsonObject();
        obj.addProperty("action_name", action);
        if (action.equals("bet") && action.equals("raise")) {
            obj.addProperty("amount", amount);
        }
        System.out.println(obj);
        MediaType JSON = MediaType.parse("application/json");
        return RequestBody.create(JSON, obj.toString());
    }

    @Override
    public String toString() {
        return this.action + " " + amount;
    }
}
