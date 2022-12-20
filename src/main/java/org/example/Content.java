package org.example;

import java.awt.*;
import java.net.URL;

public class Content {
    public String text = "";
    public String iconUrl = "";
    public String imageUrl;

    public URL btnUrl;

    public String urlText;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public URL getBtnUrl() {
        return btnUrl;
    }

    public void setBtnUrl(URL btnUrl) {
        this.btnUrl = btnUrl;
    }

    public String getUrlText() {
        return urlText;
    }

    public void setUrlText(String urlText) {
        this.urlText = urlText;
    }
}
