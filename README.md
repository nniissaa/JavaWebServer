# Java Web Server

Java'nın standart kütüphanesi kullanılarak geliştirilmiş, 1989 portunda çalışan basit bir HTTP web sunucusu.

## Gereksinimler
- JDK 17 veya üzeri (önerilen: JDK 21)
- IntelliJ IDEA veya terminal

## IntelliJ IDEA ile çalıştırma
1. IntelliJ IDEA'da bu klasörü proje olarak açın.
2. Project SDK olarak JDK 17 veya üzerini seçin.
3. `src/Main.java` dosyasını açın.
4. `main` metodunun yanındaki yeşil çalıştırma simgesine tıklayın.
5. Tarayıcıda `http://localhost:1989` adresini açın.

## Terminalden çalıştırma
Proje klasöründe:

```bash
javac -encoding UTF-8 -d out src/*.java
java -cp out Main
```

Sunucuyu durdurmak için terminalde `Ctrl + C` kullanın.

## Kullanılan teknoloji
Yalnızca Java standart kütüphanesi kullanılmıştır. Harici framework veya üçüncü parti bağımlılık yoktur.

## Proje yapısı
- `Main`: Uygulamayı başlatır.
- `WebServer`: 1989 portunda bağlantı kabul eder.
- `ClientHandler`: İstemcinin HTTP isteğini okur ve yanıtı gönderir.
- `RequestHandler`: İstek işleme sözleşmesini tanımlar.
- `ProfileRequestHandler`: GET isteğini ve istenen yolu değerlendirir.
- `MaintenanceRequestHandler`: Aynı RequestHandler arayüzünü uygulayan alternatif örnek handler'dır; SOLID'in OCP ve LSP prensiplerini göstermek için eklenmiştir.
- `HttpRequest`: İstek bilgilerini taşır.
- `HttpResponse`: Yanıt bilgilerini taşır.
- `ProfilePage`: HTML sayfasını üretir.

## Not
Bu proje eğitim amaçlı temel bir HTTP sunucusudur. Üretim ortamında kullanılmak üzere tasarlanmamıştır.

## Alternatif handler denemesi
`src/Main.java` dosyasında aşağıdaki satır bulunur:

```java
RequestHandler requestHandler = new ProfileRequestHandler();
```

Alternatif yanıtı görmek için bu satırı geçici olarak şu şekilde değiştirebilirsiniz:

```java
RequestHandler requestHandler = new MaintenanceRequestHandler();
```

Bu değişiklikte WebServer ve ClientHandler kodları değiştirilmez. Deneme sonrasında kişisel profil sayfasına dönmek için tekrar `ProfileRequestHandler` seçilmelidir.
