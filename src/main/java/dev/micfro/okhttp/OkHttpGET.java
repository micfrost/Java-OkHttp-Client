package dev.micfro.okhttp;


import okhttp3.*;

public class OkHttp {
    public static void main(String[] args) {

        // create OkHttp client object
        OkHttpClient client = new OkHttpClient();


        // create a resource JSON object
        MediaType jsonHeader = MediaType.parse("application/json; charset=utf-8");
        String jsonContent = "{" +
                "\"title\": \"Best Title\",\n" +
                "\"body\": \"Best Body\",\n" +
                "\"userId\": 1\n" +
                "}";

        RequestBody body = RequestBody.create(jsonHeader, jsonContent);


        // create a request object with the URL
        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/posts")
                .build();

        try {
            // execute newCall method to make synchronous call request
            // to the URL and get the response as an object of Response class
            Response response = client.newCall(request).execute();

            // check if the response is successful - status code 200
            if (response.isSuccessful()) {
                if (response.body() != null) {
                    // get the response body as a string
                    String responseBodyAsString = response.body().string();
                    System.out.println("Response body:");
                    System.out.println(responseBodyAsString);
                }
            } else {
                // print the error message
                System.out.println("Error occurred while sending GET request");
            }

        } catch (Exception e) {
            System.out.println("Error occurred while sending GET request: " + e.getMessage());
        }
    }
}
