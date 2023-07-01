package sg.edu.np.mad.practical3;

import android.widget.ImageView;

public class MyObject {
    private int myImageView;
    private String header;
    private String desc;

    public MyObject(int myImageView, String text,String text2) {
        this.myImageView = myImageView;
        this.header = text;
        this.desc=text2;

    }

    public MyObject() {
    }

    public int getMyImageView() {
        return myImageView;
    }

    public void setMyImageView(int myImageView) {
        this.myImageView = myImageView;
    }

    public String getHeader() {return header;}

    public void setHeader(String text) {
        this.header = text;
    }
    public String getDesc() {return desc;}

    public void setDesc(String text) {
        this.desc = text;
    }

}
