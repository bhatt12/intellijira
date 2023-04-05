package com.ukg.intellijira;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootApplication
@EnableFeignClients
public class IntelliJiraApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(IntelliJiraApplication.class, args);
		//chatGPT("generate jira story on MFA implementation using Auth0");
	}

	public static void chatGPT(String text) throws Exception {
		String url = "https://api.openai.com/v1/completions";
		HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();

		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Authorization", "Bearer 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");

		JSONObject data = new JSONObject();
		data.put("model", "text-davinci-003");
		data.put("prompt", text);
		data.put("max_tokens", 4000);
		data.put("temperature", 1.0);

		con.setDoOutput(true);
		con.getOutputStream().write(data.toString().getBytes());

		String output = new BufferedReader(new InputStreamReader(con.getInputStream())).lines()
				.reduce((a, b) -> a + b).get();

		int count = new JSONObject(output).getJSONArray("choices").length();
		for(int i=0;i< count;i++){
			System.out.println(new JSONObject(output).getJSONArray("choices").getJSONObject(0).getString("text"));
		}

	}
}
