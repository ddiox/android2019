package com.example.musiconvinyl;

import java.util.ArrayList;

public class VinylData {
    public static String[][] data = new String[][]{
    {"Silverchair", "Freak Show", "https://www.musiconvinyl.com/fotos/4268_foto2_product_groot.jpg",
            "Freak Show is the second album - after their debut Frogstomp- by the popular Australian band Silverchair, which charted in different lists all over the world (US, UK, Australia, Canada and many more). This post-grunge album is more versatile in comparison to their earlier work and it marks the beginning of the definitive band sound.", "RP. 300.000"},
    {"The Velvet Underground", "Collected", "https://www.musiconvinyl.com/fotos/3382_foto1_product_xl.jpg",
            "An album by The Velvet Underground needs to be in the collection of every legitimate music lover. Those who do not yet have an album from this legendary group can now fill this gap by purchasing the new Collected. The Collected compilation consists of 2LP's with a total of 23 songs.","RP. 500.000"},
    {"Elvis Presley", "Loving You", "https://www.musiconvinyl.com/fotos/464_foto1_product_groot.jpg",
            "This collection of hits \"Teddy Bear\", covers \"Blueberry Hill\" and \"Mean Woman Blues\", and lesser-known treasures \"Party\" and \"I Need You So\" topped the charts forten weeks running in 1957. A thoroughly enjoyable document of Presley in his pre-Army prime.","RP. 250.000"},
    {"The Wannadies", "Be a Girl", "https://www.musiconvinyl.com/fotos/4062_foto1_product_groot.jpg",
            "Swedish rockers The Wannadies reached internationally stardom by releasing their third album Be A Girl. Single \"You and Me Song\" became the group's biggest hit, peaking at number eighteen in the United Kingdom. “Might Be Stars\" became another UK hit, and sounds exactly like the Britpop from that time.","RP. 200.000"},
    {"David Bowie", "Peter and The Wolf", "https://www.musiconvinyl.com/fotos/1611_foto1_product_groot.jpg",
            "David Bowie Narrates Prokofiev's Peter And The Wolf (1978) is a classical music album containing David Bowie's narration of Sergei Prokofiev's 1936 composition Peter And The Wolf. The music is performed by the Philadelphia Orchestra conducted by Eugene Ormandy. The album reached number 136 on the US Pop Albums chart.", "RP. 100.000"},
    {"Carpenters", "Collected", "https://www.musiconvinyl.com/fotos/3379_foto2_product_groot.jpg",
            "The Collected album by the Carpenters brings a beautiful collection from the immense popular soft-pop duo. From their humble beginnings in the late '60s until today, siblings Karen and Richard Carpenter are one of the most successful duos in musical history. With Karen's absolutely perfect vocal delivery and Richard's creative arrangements, they are unstoppable.", "RP. 400.000"},
    {"Herman Brood", "Back On The Corner", "https://www.musiconvinyl.com/fotos/3688_foto2_product_groot.jpg", "Before ending his life by jumping from the Amsterdam Hilton Hotel in 2001 Herman Brood recorded his album Back on the Corner. Accompanied by a big band he ventures to interpret well-known swing classics.", "RP. 150.000"}
};

public static ArrayList<Vinyl> getListData(){
        Vinyl vinyl = null;
        ArrayList<Vinyl> list = new ArrayList<>();

        for (String[] aData : data) {
        vinyl = new Vinyl();
        vinyl.setName(aData[0]);
        vinyl.setRemarks(aData[1]);
        vinyl.setPhoto(aData[2]);
        vinyl.setDescription(aData[3]);
        vinyl.setPrice(aData[4]);

        list.add(vinyl);
        }

        return list;
        }
}
