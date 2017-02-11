package JavaBean;

/**
 * Created by user on 2017/1/21.
 */

public class InjectionStationKHH {

    /**
     * 機構名稱 : 一嘉動物醫院
     * 機構電話 : 07-3318123
     * 郵遞區號 : 80243
     * 機構地址 : 高雄市苓雅區興中一路383號
     */

    private String name;
    private String phone;
    private String zipcode;
    private String address;

    public InjectionStationKHH(String name, String phone, String zipcode, String address) {
        this.name = name;
        this.phone = phone;
        this.zipcode = zipcode;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
