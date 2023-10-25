import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

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
}












