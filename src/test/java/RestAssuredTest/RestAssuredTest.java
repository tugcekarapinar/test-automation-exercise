package RestAssuredTest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RestAssuredTest {
    public static void main(String[] args) {

        RequestSpecification request = given()
                .header("Content-Type", "application/json");

        Response response = request
                .when()
                .get("https://jsonplaceholder.typicode.com/posts")
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Status Code Test");
        if (response.getStatusCode() == 200) {
            System.out.println("Test Başarılı");
        } else {
            System.out.println("Test Başarısız: Status Code " + response.getStatusCode());
        }
        System.out.println("-----------------------------------------------------------------------------------------");


        System.out.println("JSON Yapısı Doğrulama Testi");
        JsonPath jsonPath = response.jsonPath();
        boolean isJsonInvalid = jsonPath.getList("$").stream()
                .allMatch(item -> ((java.util.Map<String, Object>) item).containsKey("userId") &&
                        ((java.util.Map<String, Object>) item).containsKey("id") &&
                        ((java.util.Map<String, Object>) item).containsKey("title") &&
                        ((java.util.Map<String, Object>) item).containsKey("body"));
        if (isJsonInvalid) {
            System.out.println("Test Başarılı");
        } else {
            System.out.println("Test Başarısız: JSON çıktısı boş veya gerekli alanların hepsi yok");
        }
        System.out.println("-----------------------------------------------------------------------------------------");


        System.out.println("Belirli Bir Değerin Doğrulanması Testi");
        String expectedTitle = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit"; //Bu değer Postman üzerinden alındı.
        String actualTitle = jsonPath.getString("find { it.id == 1 }.title");
        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Test Başarılı");
        } else {
            System.out.println("Test Başarısız: Beklenen title '" + expectedTitle + "', ama gelen title '" + actualTitle + "'");
        }
        System.out.println("-----------------------------------------------------------------------------------------");


        System.out.println("Liste Uzunluğu Kontrolü Testi");
        int listSize = jsonPath.getList("$").size();
        int minSize = 10;

        if (listSize >= minSize) {
            System.out.println("Test Başarılı");
        } else {
            System.out.println("Test Başarısız: JSON'ın içerdiği liste en az 10 eleman içermiyor. (İçerdiği Eleman Sayısı: " + listSize + ")");
        }
        System.out.println("-----------------------------------------------------------------------------------------");


        System.out.println("Dinamik Veri Kontrolleri Testi");
        List<Integer> userIds = jsonPath.getList("userId", Integer.class);
        boolean allPositive = userIds.stream().allMatch(id -> id > 0);

        if (allPositive) {
            System.out.println("Test Başarılı");
        } else {
            System.out.println("Test Başarısız: Bütün id'ler pozitif değil");
        }
        System.out.println("-----------------------------------------------------------------------------------------");
    }
}
