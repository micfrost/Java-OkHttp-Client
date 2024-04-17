package dev.micfro.okhttp;


import okhttp3.*;

public class OkHttpPUT {
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

        RequestBody body = RequestBody.create(jsonContent, jsonHeader);


        // create a request object with the URL
         Request request = new Request.Builder()
                 .url("https://jsonplaceholder.typicode.com/posts/1")
                 .put(body)
                 .build();

        try {
            // execute newCall method to make synchronous call request
            // to the URL and get the response as an object of Response class
            Response response = client.newCall(request).execute();

            // check if the response is successful - status code 200
            if (response.isSuccessful() && response.body() != null){

                    String responseBodyAsString = response.body().string();
                    System.out.println("Response body for PUT Request:");
                    System.out.println(responseBodyAsString);

            } else {
                // print the error message
                System.out.println("Error occurred while sending PUT request: " + response.code());
            }

        } catch (Exception e) {
            System.out.println("Error occurred while sending PUT request: " + e.getMessage());
        }
    }
}
