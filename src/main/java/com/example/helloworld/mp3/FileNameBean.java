package com.example.helloworld.mp3;

public class FileNameBean {
    private String originName;
    private String replaceName;

    public FileNameBean(){
    }

    public FileNameBean(String origin, String replace){
        originName=origin;
        replaceName=replace;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getReplaceName() {
        return replaceName;
    }

    public void setReplaceName(String replaceName) {
        this.replaceName = replaceName;
    }
}
