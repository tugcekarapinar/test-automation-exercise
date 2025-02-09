# Test Automation Exercise 🚀

## Akakce UI Test  

Bu proje, **Akakce.com** web sitesi üzerinde otomatik testler gerçekleştirerek temel kullanıcı senaryolarını doğrulamayı amaçlamaktadır.  


`AkakceUiTest.java` dosyasında yer alan test senaryosu aşağıdaki adımları içerir:  

    1. Kullanıcı, **Akakce.com** üzerinde oturum açar.  
    2. **iPhone** ürünlerini aratır ve listeler.
    3. İlk çıkan ürünü seçer.
    3. Seçtiği ürünü **takip listesine** ekler.  

> **Not:** `testAddFollowList` fonksiyonu içerisindeki `"userName"` ve `"userPassword"` değerleri geçerli giriş bilgileri ile değiştirilmelidir.  



## Postman API Test
Bu proje, **restful-booker.herokuapp.com/apidoc/index.html** web sitesine ait uç noktaları kullanarak Postman üzerinden API testlerini gerçekleştirmeyi amaçlamaktadır. API uç noktalarına yapılacak her çağrı için bir test yazılmıştır.

`RestfulBookerPostmanApiTest` klasörü içerisinde Postman collection ve test sonuçları JSON formatında yer almaktadır.


## Rest Assured Test
Bu proje **jsonplaceholder.typicode.com** web sitesinden /posts end pointi ile alınan json verisi üzerinde

    1. JSON Yapısı Doğrulama Testi
    2. Belirli Bir Değerin Doğrulanması Testi
    3. Liste Uzunluğu Kontrolü Testi
    4. Dinamik Veri Kontrolleri Testi

Yapılmıştır. Testi çalıştırmak için [RestfulBookerPostmanApiTest](RestfulBookerPostmanApiTest/) Klasörü içerisindeki `RestAssuredTest.java` dosyası çalıştırılmalıdır. Konsol çıktısı
![Rest Assured Test Konsol Çıktısı](Images/RestAssuredScreenShot.png)

---




