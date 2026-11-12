public class ProfilePage {
    private static final String FULL_NAME = "Nisanur Dermenci";
    private static final String STUDENT_NUMBER = "1240505802";

    public String createHtml() {
        return """
                <!DOCTYPE html>
                <html lang="tr">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Kisisel Tanitim Sayfasi</title>
                    <style>
                        body {
                            margin: 0;
                            padding: 40px 20px;
                            background-color: #f1f4f9;
                            color: #293241;
                            font-family: Arial, Helvetica, sans-serif;
                        }
                        .container {
                            max-width: 760px;
                            margin: 30px auto;
                            padding: 35px;
                            background-color: white;
                            border-radius: 14px;
                            box-shadow: 0 4px 18px rgba(0, 0, 0, 0.08);
                        }
                        h1 {
                            color: #315b96;
                            font-size: 34px;
                            margin-bottom: 10px;
                        }
                        h2 {
                            color: #64748b;
                            font-size: 21px;
                            font-weight: normal;
                        }
                        h3 {
                            color: #315b96;
                            border-bottom: 2px solid #dbe5f2;
                            padding-bottom: 9px;
                            margin-top: 30px;
                        }
                        p {
                            font-size: 17px;
                            line-height: 1.8;
                        }
                        .tag {
                            display: inline-block;
                            background-color: #e8eff9;
                            color: #315b96;
                            padding: 8px 13px;
                            border-radius: 20px;
                            margin: 5px 4px 0 0;
                            font-size: 14px;
                        }
                    </style>
                </head>
                <body>
                    <main class="container">
                        <h1>%s</h1>
                        <h2>Öğrenci No: %s</h2>
                        <h3>Hakkımda</h3>
                        <p>
                            Merhaba! Ben yazılım mühendisliği öğrencisiyim.
                            Bilgisayar bilimleri, yazılım geliştirme ve web
                            teknolojileriyle ilgileniyorum. Eğitimim boyunca
                            programlama temellerimi geliştirmeyi, öğrendiğim
                            konuları uygulamalar oluşturarak pekiştirmeyi
                            hedefliyorum.
                        </p>
                        <h3>İlgi Alanlarım</h3>
                        <span class="tag">Java</span>
                        <span class="tag">Web Teknolojileri</span>
                        <span class="tag">Yazılım Geliştirme</span>
                    </main>
                </body>
                </html>
                """.formatted(FULL_NAME, STUDENT_NUMBER);
    }
}
