package esb.bean;

public class Dbbean {
    public String TABLE_NAME;

    public String getTABLE_NAME() {
        return TABLE_NAME;
    }

    public void setTABLE_NAME(String TABLE_NAME) {
        this.TABLE_NAME = TABLE_NAME;
    }

    public Dbbean(String TABLE_NAME) {
        this.TABLE_NAME = TABLE_NAME;
    }
}
