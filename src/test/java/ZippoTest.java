import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ZippoTest {

    @Test
    public void test1(){

        given()
                // Hazırlık işlemleri kodları
                .when()
                // endpoint (url), metod u verip istek gönderiliyor

                .then()
                // assertion, test, data işlemleri
        ;
    }

    @Test
    public void statusCodeTest(){

        given()
               // hazırlık kısmı boş
                .when()
                .get("http://api.zippopotam.us/us/90210")

                .then()
                .log().body() // dönen body json data , log().all() : gidip gelen her şey
                .statusCode(200) // test kısmı olduğundan assertion status code 200 mü
        ;
    }

    @Test
    public void contentTypeTest(){

        given()

                .when()
                .get("http://api.zippopotam.us/us/90210")

                .then()
                .log().body() // dönen body json data , log().all() : gidip gelen her şey
                .statusCode(200) // test kısmı olduğundan assertion status code 200 mü
                .contentType(ContentType.JSON)  // dönen datanın tipi JSON mı
        ;
    }

    @Test
    public void checkCountryInResponseBody(){

        given()

                .when()
                .get("http://api.zippopotam.us/us/90210")

                .then()
                //.log().body()
                .statusCode(200)  // assertion
                .body("country", equalTo("United States")) //assertion
                // body nin country değişkeni "United States" eşit Mİ
        ;
    }


    @Test
    public void checkStateInResponseBody(){
        // Soru : "http://api.zippopotam.us/us/90210"  endpoint indne dönen
        // place dizisinin ilk elemanının state değerinin  "California"
        // olduğunu doğrulayınız
        given()

                .when()
                .get("http://api.zippopotam.us/us/90210")

                .then()
                .statusCode(200)
                .body("places[0].state", equalTo("California"));
        ;
    }


    @Test
    public void checkHasItem(){
        // Soru : "http://api.zippopotam.us/tr/01000"  endpoint in dönen
        // place dizisinin herhangi bir elemanında  "Dörtağaç Köyü" değerinin
        // olduğunu doğrulayınız
        given()

                .when()
                .get("http://api.zippopotam.us/tr/01000")

                .then()
                //.log().body()
                .body("places.'place name'", hasItem("Dörtağaç Köyü"))
                .statusCode(200)
        ;
    }

    // Soru : "http://api.zippopotam.us/us/90210"  endpoint in dönen
    // place dizisinin dizi uzunluğunun 1 olduğunu doğrulayınız.

    @Test
    public void bodyArrayHasSizeTest(){
        given()

                .when()
                .get("http://api.zippopotam.us/us/90210")

                .then()
                .body("places", hasSize(1)); // places ın item size 1 e eşit mi
        ;
    }

    @Test
    public void bodyArrayHasSizeTest2(){
        given()

                .when()
                .get("http://api.zippopotam.us/us/90210")

                .then()
                .body("places.size()", equalTo(1)); // places ın item size 1 e eşit mi
        ;
    }


}












