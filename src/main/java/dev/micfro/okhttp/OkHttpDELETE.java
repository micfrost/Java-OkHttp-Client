package dev.micfro.okhttp;


import okhttp3.*;


public class OkHttpDELETE {
    public static void main(String[] args) {
        // Create OkHttp client object
        OkHttpClient client = new OkHttpClient();

        // Create a request object with the URL and set the method to DELETE
        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/posts/1")  // Assume post 1 exists and we are deleting it
                .delete() // No body is needed for a DELETE request
                .build();

        try {
            // Execute the request and get the response
            Response response = client.newCall(request).execute();

            // Check if the response is successful - status code 200
            if (response.isSuccessful()) {
                System.out.println("Successfully deleted the resource. Status Code: " + response.code());
            } else {
                // Print the error message
                System.out.println("Error occurred while sending DELETE request: " + response.code());
            }
        } catch (Exception e) {
            System.out.println("Error occurred while sending DELETE request: " + e.getMessage());
        }
    }
}
