package top.acgnx.hitokoto.pojo;

public class Param {
    private String c;
    private String encode;
    private String charset;
    private String callback;
    private String select;
    private String min_length;

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getEncode() {
        return encode;
    }

    public void setEncode(String encode) {
        this.encode = encode;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    public String getMin_length() {
        return min_length;
    }

    public void setMin_length(String min_length) {
        this.min_length = min_length;
    }

    @Override
    public String toString() {
        return "Param{" +
                "c='" + c + '\'' +
                ", encode='" + encode + '\'' +
                ", charset='" + charset + '\'' +
                ", callback='" + callback + '\'' +
                ", select='" + select + '\'' +
                ", min_length='" + min_length + '\'' +
                '}';
    }
}
