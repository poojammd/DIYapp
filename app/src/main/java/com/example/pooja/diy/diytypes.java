package com.example.pooja.diy;

import java.io.Serializable;

public class diytypes  implements Serializable {
    public String diytype,imageName,youtubelink;
    public diytypes(String diytype,String imageName,String youtubelink){
        this.diytype=diytype;
        this.imageName=imageName;
        this.youtubelink=youtubelink;



    }
}

