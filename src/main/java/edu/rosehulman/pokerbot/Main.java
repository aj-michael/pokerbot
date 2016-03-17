package edu.rosehulman.pokerbot;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Main {
    static final OkHttpClient client = new OkHttpClient();
    //static final String key = "deal-phase-key";
    static final String key = "947d673d-42ce-4379-8b78-bbb87aad79e6";
    //static final String url = "http://enova-no-limit-code-em.herokuapp.com/sandbox/players/" + key;
    static final String url = "http://enova-no-limit-code-em.herokuapp.com/api/players/" + key;
    static final String actionUrl = url + "/action";
    static final Gson gson = new Gson();

    public static void main(String args[]) {
        Strategy strategy = new CactusKevStrategy();
        while (true) {
            try {
                Data state = fetchData();
                System.out.println(state);
                if (state.your_turn) {
                    postAction(strategy, state);
                }
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static Data postAction(Strategy strategy, Data state) throws IOException {
        Request req = new Request.Builder()
                .url(actionUrl)
                .post(strategy.process(state).toRequest())
                .addHeader("Content-type", "application/json")
                .build();
        Response response = client.newCall(req).execute();
        System.out.println(strategy.process(state));
        return gson.fromJson(response.body().charStream(), Data.class);
    }

    static Data fetchData() throws IOException {
        Request req = new Request.Builder()
                .url(url)
                .get()
                .build();
        Response response = client.newCall(req).execute();
        return gson.fromJson(response.body().charStream(), Data.class);
    }
}